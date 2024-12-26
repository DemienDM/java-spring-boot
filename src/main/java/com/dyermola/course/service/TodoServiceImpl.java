package com.dyermola.course.service;

import com.dyermola.course.domain.repository.TaskHistoryRepository;
import com.dyermola.course.domain.repository.TodoRepository;
import com.dyermola.course.domain.service.TodoService;
import com.dyermola.course.dto.TodoCreateDto;
import com.dyermola.course.dto.TodoResponseDto;
import com.dyermola.course.dto.TodoUpdateDto;
import com.dyermola.course.entity.TaskHistory;
import com.dyermola.course.entity.Todo;
import com.dyermola.course.mapper.TodoMapper;
import com.dyermola.course.type.TodoPriorityType;
import com.dyermola.course.type.TodoStatusType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {
    private final TaskHistoryRepository taskHistoryRepository;
    private final TodoRepository todoRepository;
    private final TodoMapper todoMapper;

    public TodoServiceImpl(TodoMapper todoMapper, TodoRepository todoRepository, TaskHistoryRepository taskHistoryRepository) {
        this.taskHistoryRepository = taskHistoryRepository;
        this.todoRepository = todoRepository;
        this.todoMapper = todoMapper;
    }

    @Override
    public TodoResponseDto save(TodoCreateDto todoCreateDto) {
        Todo todo = todoMapper.toEntity(todoCreateDto);
        return todoMapper.toDto(todoRepository.save(todo));
    }

    @Override
    public void deleteById(Long id) {
        todoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TodoResponseDto updateById(Long id, TodoUpdateDto todoUpdateDto) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isEmpty()) {
            throw new RuntimeException("Todo with id: " + id + " not found.");
        }

        Todo todo = optionalTodo.get();
        String oldState = todo.toString();

        if (todoUpdateDto.title() != null && !todoUpdateDto.title().isBlank()) {
            todo.setTitle(todoUpdateDto.title());
        }

        if (todoUpdateDto.description() != null && !todoUpdateDto.description().isBlank()) {
            todo.setDescription(todoUpdateDto.description());
        }

        if (todoUpdateDto.dueDate() != null) {
            todo.setDueDate(todoUpdateDto.dueDate());
        }

        if (todoUpdateDto.priority() != null) {
            todo.setPriority(TodoPriorityType.valueOf(todoUpdateDto.priority()));
        }

        if (todoUpdateDto.status() != null) {
            todo.setStatus(TodoStatusType.valueOf(todoUpdateDto.status()));
        }

        todo = todoRepository.save(todo);

        taskHistoryRepository.save(new TaskHistory(
                todo.getId(),
                oldState,
                todo.toString(),
                "admin"
        ));

        return todoMapper.toDto(todo);
    }
}
