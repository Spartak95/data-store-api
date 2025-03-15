package com.xcoder.data.store.repository;

import java.util.Optional;
import java.util.Set;

import com.xcoder.data.store.model.MeasurementType;
import com.xcoder.data.store.model.Summary;
import com.xcoder.data.store.model.SummaryType;

public interface SummaryRepository {
    Optional<Summary> findBySensorId(long sensorId, Set<MeasurementType> measurementTypes,
                                     Set<SummaryType> summaryTypes);
}
