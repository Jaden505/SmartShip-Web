package com.server.server.controllers;

import com.server.server.repository.ChartInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.server.server.model.Chart;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/test")
public class ChartInfoController {
    @Autowired
    private ChartInfoRepository chartRepo;

    @GetMapping("/watertank")
    public List<Chart> getWaterTank(){
        return chartRepo.findAll();
    }
}
