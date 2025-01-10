package com.ceylanyildirim.ToDoList.service;

import com.ceylanyildirim.ToDoList.dto.TodoDto;

import java.util.List;

public interface ITodoService {
    List<TodoDto> getAllTodos();
    TodoDto createTodo(TodoDto todoDto);
    TodoDto updateTodo(Long id, TodoDto todoDto);
    void deleteTodoById(Long id);

}
