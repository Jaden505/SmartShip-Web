package com.server.server.controllers;

import com.server.server.model.Engine;
import com.server.server.repository.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/test")
public class EngineController {
    @Autowired
    private EngineRepository engineRepository;

    @GetMapping("/engine")
    public List<Engine> getEngine(){
        return engineRepository.findAll();
    }
}
