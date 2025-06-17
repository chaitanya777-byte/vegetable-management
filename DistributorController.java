package com.example.vegetable.controller;

import com.example.vegetable.model.Distributor;
import com.example.vegetable.repository.DistributorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/distributors")
public class DistributorController {
    @Autowired private DistributorRepository distributorRepo;

    @PostMapping("/register")
    public Distributor register(@RequestBody Map<String, String> body) {
        return distributorRepo.save(new Distributor(null, body.get("name")));
    }
}