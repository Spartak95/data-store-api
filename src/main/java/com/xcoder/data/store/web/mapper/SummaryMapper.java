package com.xcoder.data.store.web.mapper;

import com.xcoder.data.store.model.Summary;
import com.xcoder.data.store.web.dto.SummaryDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SummaryMapper extends Mappable<Summary, SummaryDto> {
}
