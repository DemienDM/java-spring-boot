package com.dyermola.course.mapper;

import com.dyermola.course.config.MapperConfig;
import com.dyermola.course.dto.TodoCreateDto;
import com.dyermola.course.dto.TodoResponseDto;
import com.dyermola.course.entity.Todo;
import org.mapstruct.Mapper;

@Mapper(config = MapperConfig.class)
public interface TodoMapper {
    TodoResponseDto toDto(Todo todo);

    Todo toEntity(TodoCreateDto todoCreateDto);
}
