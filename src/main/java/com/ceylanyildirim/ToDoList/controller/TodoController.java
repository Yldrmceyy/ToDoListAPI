package com.ceylanyildirim.ToDoList.controller;

import com.ceylanyildirim.ToDoList.dto.TodoDto;
import com.ceylanyildirim.ToDoList.service.ITodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final ITodoService todoService;

    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos); // 200 OK
    }

    @PostMapping
    public ResponseEntity<TodoDto> createTodo(@RequestBody @Valid TodoDto todoDto) {
        TodoDto createdTodo = todoService.createTodo(todoDto);
        return new ResponseEntity<>(createdTodo, HttpStatus.CREATED); // 201 CREATED
    }


    @PutMapping("/{id}")
    public ResponseEntity<TodoDto> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        TodoDto updatedTodo = todoService.updateTodo(id, todoDto);
        return ResponseEntity.ok(updatedTodo); // 200 OK
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build(); // 204 NO CONTENT
    }
}
