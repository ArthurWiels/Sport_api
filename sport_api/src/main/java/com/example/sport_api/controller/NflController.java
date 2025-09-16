package com.example.sport_api.controller;

import com.example.sport_api.services.ImportNflService;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/nfl")
@RequiredArgsConstructor
@CrossOrigin
public class NflController {

    private final ImportNflService importNflService = new ImportNflService();

    @GetMapping("/teams")
    public JsonNode getAllTeam(){
        return importNflService.getTeams();
    }
}
