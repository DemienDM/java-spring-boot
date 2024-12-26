package com.dyermola.course.dto;

import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record TodoResponseDto(
        @NotEmpty
        Long id,
        String title,
        String description,
        LocalDateTime dueDate,
        String priority,
        String status,
        LocalDateTime createdDate,
        LocalDateTime updatedDate,
        Long userId
) {
}
