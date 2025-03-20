package com.example.TailorGen.dao.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PromptRequest {
    @NotBlank(message = "User input cannot be empty")
    private String userInput;
}

