package com.wincom.dbsyncagent.config.kafka;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ObjectMapperConfig {
}
