package com.xcoder.data.store.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Summary {
    private long sensorId;
    private Map<MeasurementType, List<SummaryEntry>> values;

    public Summary() {
        this.values = new EnumMap<>(MeasurementType.class);
    }

    public void addValue(MeasurementType type, SummaryEntry value) {
        if (this.values.containsKey(type)) {
            List<SummaryEntry> entries = new ArrayList<>(values.get(type));
            entries.add(value);
            values.put(type, entries);
        } else {
            values.put(type, List.of(value));
        }
    }
}
