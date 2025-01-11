package com.ceylanyildirim.ToDoList.service;

import com.ceylanyildirim.ToDoList.dto.TodoDto;

import java.util.List;

/**
 * ITodoService, iş mantığını tanımlayan arayüzdür.
 */
public interface ITodoService {
    List<TodoDto> getAllTodos(); // Tüm görevleri getirir.
    TodoDto getTodoById(Long id); // Belirtilen ID'ye göre bir görevi getirir.
    TodoDto createTodo(TodoDto todoDto); // Yeni bir görev oluşturur.
    TodoDto updateTodo(Long id, TodoDto todoDto); // Mevcut bir görevi günceller.
    void deleteTodoById(Long id); // Belirtilen ID'ye sahip bir görevi siler.
}
