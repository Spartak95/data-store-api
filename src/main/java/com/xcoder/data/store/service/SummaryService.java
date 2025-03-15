package com.xcoder.data.store.service;

import java.util.Set;

import com.xcoder.data.store.model.MeasurementType;
import com.xcoder.data.store.model.Summary;
import com.xcoder.data.store.model.SummaryType;

public interface SummaryService {
    Summary get(long sensorId, Set<MeasurementType> measurementTypes, Set<SummaryType> summaryTypes);
}
