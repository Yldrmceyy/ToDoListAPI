package com.ceylanyildirim.ToDoList.repository;

import com.ceylanyildirim.ToDoList.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
