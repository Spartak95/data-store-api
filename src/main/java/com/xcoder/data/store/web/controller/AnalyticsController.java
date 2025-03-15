package com.xcoder.data.store.web.controller;

import java.util.Set;

import com.xcoder.data.store.model.MeasurementType;
import com.xcoder.data.store.model.Summary;
import com.xcoder.data.store.model.SummaryType;
import com.xcoder.data.store.service.SummaryService;
import com.xcoder.data.store.web.dto.SummaryDto;
import com.xcoder.data.store.web.mapper.SummaryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {
    private final SummaryMapper summaryMapper;
    private final SummaryService summaryService;

    @GetMapping("/summary/{sensorId}")
    public SummaryDto getSummary(@PathVariable("sensorId") long sensorId,
                                 @RequestParam(value = "mt", required = false) Set<MeasurementType> measurementTypes,
                                 @RequestParam(value = "st", required = false) Set<SummaryType> summaryTypes) {
        Summary summary = summaryService.get(sensorId, measurementTypes, summaryTypes);
        return summaryMapper.toDto(summary);
    }
}
