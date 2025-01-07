package com.dyermola.course.domain.service;

import com.dyermola.course.dto.TodoCreateDto;
import com.dyermola.course.dto.TodoResponseDto;
import com.dyermola.course.dto.TodoUpdateDto;

public interface TodoService {
    TodoResponseDto save(TodoCreateDto todoCreateDto);

    void deleteById(Long id);

    TodoResponseDto updateById(Long id, TodoUpdateDto todoUpdateDto);
}
