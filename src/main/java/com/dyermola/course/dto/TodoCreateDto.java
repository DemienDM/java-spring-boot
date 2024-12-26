package com.dyermola.course.dto;

import com.dyermola.course.type.TodoPriorityType;
import com.dyermola.course.validation.ValidEnum;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record TodoCreateDto(
        @NotEmpty
        @Length(min = 3, max = 100)
        String title,

        @Length(min = 3, max = 500)
        String description,

        @NotNull
        @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
        LocalDateTime dueDate,

        @ValidEnum(value = TodoPriorityType.class, message = "Invalid priority value.")
        String priority
) {
}
