package com.ceylanyildirim.ToDoList.service.impl;

import com.ceylanyildirim.ToDoList.dto.TodoDto;
import com.ceylanyildirim.ToDoList.entity.Todo;
import com.ceylanyildirim.ToDoList.repository.TodoRepository;
import com.ceylanyildirim.ToDoList.service.ITodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServisImpl implements ITodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    public TodoServisImpl(TodoRepository todoRepository, ModelMapper modelMapper) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<TodoDto> getAllTodos() {
        return todoRepository.findAll()
                .stream()
                .map(todo -> modelMapper.map(todo,TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo= modelMapper.map(todoDto, Todo.class);
        Todo savedTodo= todoRepository.save(todo);
        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found"));
        existingTodo.setTitle(todoDto.getTitle());
        existingTodo.setDescription(todoDto.getDescription());
        existingTodo.setCompleted(todoDto.isCompleted());
        Todo updatedTodo = todoRepository.save(existingTodo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodoById(Long id) {

    }
}
