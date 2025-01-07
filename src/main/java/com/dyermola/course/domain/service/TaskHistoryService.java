package com.dyermola.course.domain.service;

import com.dyermola.course.dto.TaskHistoryResponseDto;

import java.util.List;

public interface TaskHistoryService {
    List<TaskHistoryResponseDto> findByTodoId(Long todoId, Long limit);
}
