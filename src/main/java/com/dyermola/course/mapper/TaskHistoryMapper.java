package com.dyermola.course.mapper;

import com.dyermola.course.config.MapperConfig;
import com.dyermola.course.dto.TaskHistoryResponseDto;
import com.dyermola.course.entity.TaskHistory;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface TaskHistoryMapper {
    TaskHistoryResponseDto toDto(TaskHistory taskHistory);
}
