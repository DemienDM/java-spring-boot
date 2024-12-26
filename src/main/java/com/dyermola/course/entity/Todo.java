package com.dyermola.course.entity;

import com.dyermola.course.type.TodoPriorityType;
import com.dyermola.course.type.TodoStatusType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "todos")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private TodoPriorityType priority;

    @Enumerated(EnumType.STRING)
    private TodoStatusType status;

    @CreationTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm:ss")
    private LocalDateTime updatedDate;

    private Long userId;

    public Todo() { }

    public Todo(String title, String description, LocalDateTime dueDate, TodoPriorityType priority) {
        this.title = title;
        this.description = description != null ? description : "";
        this.dueDate = dueDate;
        this.priority = priority;
        this.status = TodoStatusType.PENDING;
        this.userId = 1L;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }

    public TodoPriorityType getPriority() {
        return priority;
    }

    public void setPriority(TodoPriorityType priority) {
        this.priority = priority;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public TodoStatusType getStatus() {
        return status;
    }

    public void setStatus(TodoStatusType status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Todo{"
                + "id=" + id
                + ", title='" + title + '\''
                + ", description='" + description + '\''
                + ", dueDate=" + dueDate
                + ", priority=" + priority
                + ", status=" + status
                + ", createdDate=" + createdDate
                + ", updatedDate=" + updatedDate
                + ", userId=" + userId
                + '}';
    }
}
