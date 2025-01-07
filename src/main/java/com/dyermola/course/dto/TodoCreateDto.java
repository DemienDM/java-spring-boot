package com.dyermola.course.dto;

import com.dyermola.course.type.TodoPriorityType;
import com.dyermola.course.validation.ValidEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record TodoCreateDto(
        @NotEmpty
        @Size(min = 3, max = 100)
        String title,

        @Size(min = 3, max = 500)
        String description,

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
        LocalDateTime dueDate,

        @ValidEnum(value = TodoPriorityType.class, message = "Invalid priority value.")
        String priority
) {
}
