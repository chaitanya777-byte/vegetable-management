package com.example.vegetable.controller;

import com.example.vegetable.model.Farmer;
import com.example.vegetable.service.FarmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/farmers")
public class FarmerController {
    @Autowired private FarmerService farmerService;

    @PostMapping("/register")
    public ResponseEntity<Farmer> registerFarmer(@RequestBody Map<String, String> request) {
        Farmer f = farmerService.registerFarmer(request.get("name"));
        return ResponseEntity.ok(f);
    }
}