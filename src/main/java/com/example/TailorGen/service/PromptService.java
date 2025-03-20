package com.example.TailorGen.service;


import com.example.TailorGen.dao.dto.PromptRequest;
import com.example.TailorGen.dao.dto.PromptResponse;
import com.example.TailorGen.utils.HttpClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.json.JSONObject;

@Service
public class PromptService {

    @Value("${huggingface.api.url}")
    private String apiUrl;

    @Value("${huggingface.api.key}")
    private String apiKey;

    public PromptResponse generatePrompt(PromptRequest request) {
        try {
            JSONObject jsonPayload = new JSONObject();
            jsonPayload.put("inputs", "Generate a creative prompt for: " + request.getUserInput());

            String response = HttpClientUtil.postRequest(apiUrl, jsonPayload.toString(), apiKey);
            JSONObject jsonResponse = new JSONObject(response);

            String generatedPrompt = jsonResponse.getString("generated_text");
            return new PromptResponse(generatedPrompt);

        } catch (Exception e) {
            return new PromptResponse("Error generating prompt: " + e.getMessage());
        }
    }
}

