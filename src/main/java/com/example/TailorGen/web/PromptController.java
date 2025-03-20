package com.example.TailorGen.web;


import com.example.TailorGen.dao.dto.PromptRequest;
import com.example.TailorGen.dao.dto.PromptResponse;
import com.example.TailorGen.service.PromptService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prompt")
public class PromptController {

    private final PromptService promptService;

    public PromptController(PromptService promptService) {
        this.promptService = promptService;
    }

    @PostMapping("/generate")
    public ResponseEntity<PromptResponse> generatePrompt(@Valid @RequestBody PromptRequest request) {
        return ResponseEntity.ok(promptService.generatePrompt(request));
    }
}
