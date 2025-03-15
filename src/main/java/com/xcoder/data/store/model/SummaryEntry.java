package com.xcoder.data.store.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SummaryEntry {
    private SummaryType type;
    private double value;
}
