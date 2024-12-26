package com.dyermola.course.mapper;

import com.dyermola.course.dto.TodoCreateDto;
import com.dyermola.course.dto.TodoResponseDto;
import com.dyermola.course.entity.Todo;
import com.dyermola.course.type.TodoPriorityType;
import org.springframework.stereotype.Component;

@Component
public class TodoTmp {
    public TodoResponseDto toDto(Todo todo) {
        return new TodoResponseDto(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getDueDate(),
                todo.getPriority().name(),
                todo.getStatus().name(),
                todo.getCreatedDate(),
                todo.getUpdatedDate(),
                todo.getUserId()
        );
    }

    public Todo toEntity(TodoCreateDto todoCreateDto) {
        return new Todo(
                todoCreateDto.title(),
                todoCreateDto.description(),
                todoCreateDto.dueDate(),
                TodoPriorityType.valueOf(todoCreateDto.priority())
        );
    }
}
