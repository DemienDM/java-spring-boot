package com.dyermola.course.dto;

import com.dyermola.course.type.TodoPriorityType;
import com.dyermola.course.type.TodoStatusType;
import com.dyermola.course.validation.ValidEnum;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

public record TodoUpdateDto(
        @Size(min = 3, max = 100)
        String title,

        @Size(min = 3, max = 500)
        String description,

        @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
        LocalDateTime dueDate,

        @ValidEnum(value = TodoPriorityType.class, message = "Invalid priority value.")
        String priority,

        @ValidEnum(value = TodoStatusType.class, message = "Invalid status value.")
        String status
) {
}
