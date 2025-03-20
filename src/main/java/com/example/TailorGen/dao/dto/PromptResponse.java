package com.example.TailorGen.dao.dto;

import lombok.Data;

@Data
public class PromptResponse {
    private String generatedPrompt;

    public PromptResponse(String generatedPrompt) {
        this.generatedPrompt = generatedPrompt;
    }
}