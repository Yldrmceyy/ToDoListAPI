package com.ceylanyildirim.ToDoList.controller;

import com.ceylanyildirim.ToDoList.dto.TodoDto;
import com.ceylanyildirim.ToDoList.service.ITodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private ITodoService todoService;

    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }
    @GetMapping
    public List<TodoDto> getAllTodos() {
        return todoService.getAllTodos();
    }

    @PostMapping
    public TodoDto createTodo(@RequestBody TodoDto todoDto) {
        return todoService.createTodo(todoDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        return ResponseEntity.ok(todoService.updateTodo(id, todoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }
}
