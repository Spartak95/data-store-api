package com.xcoder.data.store.service;

import java.util.Set;

import com.xcoder.data.store.exception.SensorNotFoundException;
import com.xcoder.data.store.model.MeasurementType;
import com.xcoder.data.store.model.Summary;
import com.xcoder.data.store.model.SummaryType;
import com.xcoder.data.store.repository.SummaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService {
    private final SummaryRepository summaryRepository;

    @Override
    public Summary get(long sensorId, Set<MeasurementType> measurementTypes, Set<SummaryType> summaryTypes) {
        return summaryRepository.findBySensorId(
            sensorId,
            measurementTypes == null ? Set.of(MeasurementType.values()) : measurementTypes,
            summaryTypes == null ? Set.of(SummaryType.values()) : summaryTypes
        ).orElseThrow(SensorNotFoundException::new);
    }
}
