package com.ceylanyildirim.ToDoList.controller;

import com.ceylanyildirim.ToDoList.dto.TodoDto;
import com.ceylanyildirim.ToDoList.service.ITodoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** TodoController sınıfı, Todo API için gelen HTTP isteklerini karşılar.
        * CRUD (Create, Read, Update, Delete) işlemlerini yönetir.
        */


@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final ITodoService todoService;

     /**
      * Sınıfın kurucu metodu, bağımlılık enjeksiyonu ile ITodoService'i alır.
      */
    public TodoController(ITodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoDto>> getAllTodos() {
        List<TodoDto> todos = todoService.getAllTodos();
        return ResponseEntity.ok(todos); // 200 OK
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoDto> getTodoById(@PathVariable Long id) {
        TodoDto todo = todoService.getTodoById(id);
        return ResponseEntity.ok(todo); // 200 OK ve Todo verisini döndür
    }

    @PostMapping
    public ResponseEntity<Map<String, String>> createTodo(@RequestBody @Valid TodoDto todoDto) {
        TodoDto createdTodo = todoService.createTodo(todoDto);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Todo successfully created!");
        response.put("id", createdTodo.getId().toString());
        return new ResponseEntity<>(response, HttpStatus.CREATED); // 201 CREATED
    }


    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateTodo(@PathVariable Long id, @RequestBody TodoDto todoDto) {
        TodoDto updatedTodo = todoService.updateTodo(id, todoDto);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Todo successfully updated!");
        response.put("id", updatedTodo.getId().toString());
        return ResponseEntity.ok(response); // 200 OK
    }

     @DeleteMapping("/{id}")
     public ResponseEntity<Map<String, String>> deleteTodoById(@PathVariable Long id) {
         todoService.deleteTodoById(id);
         Map<String, String> response = new HashMap<>();
         response.put("message", "Todo successfully deleted!");
         response.put("id", id.toString());
         return ResponseEntity.ok(response);
     }

 }
