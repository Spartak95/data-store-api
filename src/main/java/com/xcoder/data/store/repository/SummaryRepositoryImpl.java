package com.xcoder.data.store.repository;

import java.util.Optional;
import java.util.Set;

import com.xcoder.data.store.config.RedisSchema;
import com.xcoder.data.store.model.MeasurementType;
import com.xcoder.data.store.model.Summary;
import com.xcoder.data.store.model.SummaryEntry;
import com.xcoder.data.store.model.SummaryType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository
@RequiredArgsConstructor
public class SummaryRepositoryImpl implements SummaryRepository {
    private final JedisPool jedisPool;

    @Override
    public Optional<Summary> findBySensorId(long sensorId, Set<MeasurementType> measurementTypes,
                                            Set<SummaryType> summaryTypes) {
        try(Jedis jedis = jedisPool.getResource()) {
            if (!jedis.sismember(RedisSchema.sensorKeys(), String.valueOf(sensorId))) {
                return Optional.empty();
            }

            if (measurementTypes.isEmpty() && !summaryTypes.isEmpty()) {
                return getSummary(sensorId, Set.of(MeasurementType.values()), summaryTypes, jedis);
            } else if (!measurementTypes.isEmpty() && summaryTypes.isEmpty()) {
                return getSummary(sensorId, measurementTypes, Set.of(SummaryType.values()), jedis);
            } else {
                return getSummary(sensorId, measurementTypes, summaryTypes, jedis);
            }
        }
    }

    private Optional<Summary> getSummary(long sensorId,
                                         Set<MeasurementType> measurementTypes,
                                         Set<SummaryType> summaryTypes,
                                         Jedis jedis) {
        Summary summary = new Summary();
        summary.setSensorId(sensorId);

        for (MeasurementType measurementType : measurementTypes) {
            for (SummaryType summaryType : summaryTypes) {
                SummaryEntry summaryEntry  = new SummaryEntry();
                summaryEntry.setType(summaryType);
                String value = jedis.hget(RedisSchema.summaryKey(sensorId, measurementType),
                                          summaryType.name().toLowerCase());

                if (value != null) {
                    summaryEntry.setValue(Double.parseDouble(value));
                }

                summary.addValue(measurementType, summaryEntry);
            }
        }

        return Optional.of(summary);
    }
}
