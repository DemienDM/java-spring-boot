package com.dyermola.course.controller;

import com.dyermola.course.domain.service.TodoService;
import com.dyermola.course.dto.TodoCreateDto;
import com.dyermola.course.dto.TodoResponseDto;
import com.dyermola.course.dto.TodoUpdateDto;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

    private final TodoService todoService;

    TodoController(TodoService todoService) {
        this.todoService = todoService;
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
}
