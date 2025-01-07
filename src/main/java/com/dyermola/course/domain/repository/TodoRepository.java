package com.dyermola.course.domain.repository;

import com.dyermola.course.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
