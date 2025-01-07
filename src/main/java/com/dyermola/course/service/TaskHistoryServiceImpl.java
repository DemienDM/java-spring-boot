package com.dyermola.course.service;

import com.dyermola.course.domain.repository.TaskHistoryRepository;
import com.dyermola.course.domain.service.TaskHistoryService;
import com.dyermola.course.dto.TaskHistoryResponseDto;
import com.dyermola.course.entity.TaskHistory;
import com.dyermola.course.mapper.TaskHistoryMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskHistoryServiceImpl implements TaskHistoryService {
    private final TaskHistoryRepository taskHistoryRepository;
    private final TaskHistoryMapper taskHistoryMapper;

    public TaskHistoryServiceImpl(TaskHistoryRepository taskHistoryRepository, TaskHistoryMapper taskHistoryMapper) {
        this.taskHistoryRepository = taskHistoryRepository;
        this.taskHistoryMapper = taskHistoryMapper;
    }

    public List<TaskHistoryResponseDto> findByTodoId(Long todoId, Long limit) {
        List<TaskHistory> taskHistoryList = taskHistoryRepository.findByTodoId(todoId, limit);

        return taskHistoryList
                .stream()
                .map(taskHistoryMapper::toDto)
                .toList();
    }
}
