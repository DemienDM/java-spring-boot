package com.dyermola.course.dto;

import java.time.LocalDateTime;

public record TodoResponseDto(
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
