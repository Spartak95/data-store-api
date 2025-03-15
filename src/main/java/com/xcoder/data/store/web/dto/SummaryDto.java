package com.xcoder.data.store.web.dto;

import java.util.List;
import java.util.Map;

import com.xcoder.data.store.model.MeasurementType;
import com.xcoder.data.store.model.SummaryEntry;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SummaryDto {
    private long sensorId;
    private Map<MeasurementType, List<SummaryEntry>> values;
}
