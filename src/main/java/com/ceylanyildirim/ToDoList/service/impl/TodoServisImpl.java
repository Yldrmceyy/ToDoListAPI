package com.ceylanyildirim.ToDoList.service.impl;

import com.ceylanyildirim.ToDoList.dto.TodoDto;
import com.ceylanyildirim.ToDoList.entity.Todo;
import com.ceylanyildirim.ToDoList.exception.BaseException;
import com.ceylanyildirim.ToDoList.exception.ErrorMessage;
import com.ceylanyildirim.ToDoList.exception.MessageType;
import com.ceylanyildirim.ToDoList.repository.TodoRepository;
import com.ceylanyildirim.ToDoList.service.ITodoService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * TodoServisImpl, ITodoService arayüzünü implement eden sınıftır.
 * Görev yönetimiyle ilgili iş mantığını içerir.
 */

@Service
public class TodoServisImpl implements ITodoService {

    private final TodoRepository todoRepository;
    private final ModelMapper modelMapper;

    public TodoServisImpl(TodoRepository todoRepository, ModelMapper modelMapper) {
        this.todoRepository = todoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        if (todos.isEmpty()) {
            throw new BaseException(new ErrorMessage(
                    MessageType.NO_RECORD_EXIST,
                    "Herhangi bir kayıt bulunamadı."
            ));
        }

        return todos.stream()
                .map(todo -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto getTodoById(Long id) {
        // Eğer ID ile Todo bulunamazsa, BaseException fırlat
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new BaseException(new ErrorMessage(
                        MessageType.NO_RECORD_EXIST,
                        "Kayıt bulunamadı: ID " + id
                )));
        return modelMapper.map(todo, TodoDto.class); // Todo nesnesini DTO'ya dönüştür ve döndür
    }

    @Override
    public TodoDto createTodo(TodoDto todoDto) {
        // Aynı başlığa sahip bir Todo kontrolü
        if (todoRepository.existsByTitle(todoDto.getTitle())) {
            throw new BaseException(new ErrorMessage(
                    MessageType.GENERAL_EXCEPTION,
                    "Aynı başlığa sahip bir Todo zaten mevcut: " + todoDto.getTitle()
            ));
        }

        Todo todo = modelMapper.map(todoDto, Todo.class);
        Todo savedTodo = todoRepository.save(todo);
        return modelMapper.map(savedTodo, TodoDto.class);
    }

    @Override
    public TodoDto updateTodo(Long id, TodoDto todoDto) {
        // Güncellenecek Todo kontrolü
        Todo existingTodo = todoRepository.findById(id)
                .orElseThrow(() -> new BaseException(new ErrorMessage(
                        MessageType.NO_RECORD_EXIST,
                        "Güncellenecek kayıt bulunamadı: ID " + id
                )));

        existingTodo.setTitle(todoDto.getTitle());
        existingTodo.setDescription(todoDto.getDescription());
        existingTodo.setCompleted(todoDto.isCompleted());

        Todo updatedTodo = todoRepository.save(existingTodo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodoById(Long id) {
        // Silinecek Todo kontrolü
        if (!todoRepository.existsById(id)) {
            throw new BaseException(new ErrorMessage(
                    MessageType.NO_RECORD_EXIST,
                    "Silinecek kayıt bulunamadı: ID " + id
            ));
        }

        todoRepository.deleteById(id);
    }
}
