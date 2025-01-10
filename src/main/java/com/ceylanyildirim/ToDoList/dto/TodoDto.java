package com.ceylanyildirim.ToDoList.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
public class TodoDto {

    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private boolean completed;


}
