package com.ceylanyildirim.ToDoList.repository;

import com.ceylanyildirim.ToDoList.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    boolean existsByTitle(String title); // Aynı başlıkta bir Todo'nun var olup olmadığını kontrol eder.
    boolean existsById(Long id);         // ID'ye göre kontrol.
}
