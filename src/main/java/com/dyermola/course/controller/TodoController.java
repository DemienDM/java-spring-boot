package com.dyermola.course.controller;

import com.dyermola.course.domain.service.TaskHistoryService;
import com.dyermola.course.domain.service.TodoService;
import com.dyermola.course.dto.TaskHistoryResponseDto;
import com.dyermola.course.dto.TodoCreateDto;
import com.dyermola.course.dto.TodoResponseDto;
import com.dyermola.course.dto.TodoUpdateDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    private final TodoService todoService;
    private final TaskHistoryService taskHistoryService;

    public TodoController(TodoService todoService, TaskHistoryService taskHistoryService) {
        this.todoService = todoService;
        this.taskHistoryService = taskHistoryService;
    }

    @PostMapping
    public TodoResponseDto save(@Valid @RequestBody TodoCreateDto todoCreateDto) {
        return todoService.save(todoCreateDto);
    }

    @PutMapping("/{id}")
    public TodoResponseDto update(@PathVariable Long id, @Valid @RequestBody TodoUpdateDto todoUpdateDto) {
        return todoService.updateById(id, todoUpdateDto);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        todoService.deleteById(id);
    }

    @GetMapping("/{id}/history")
    public List<TaskHistoryResponseDto> findHistoryByTodoId(@PathVariable Long id) {
        return taskHistoryService.findByTodoId(id, 10L);
    }
}
