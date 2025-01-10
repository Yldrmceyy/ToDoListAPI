package com.ceylanyildirim.ToDoList.service.impl;

import com.ceylanyildirim.ToDoList.dto.TodoDto;
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
        return null;
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        return null;
    }

    @Override
    public void deleteTodoById(Long id) {

    }
}
