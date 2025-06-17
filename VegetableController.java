package com.example.vegetable.controller;

import com.example.vegetable.model.*;
import com.example.vegetable.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/vegetables")
public class VegetableController {
    @Autowired private VegetableRepository vegetableRepo;
    @Autowired private FarmerRepository farmerRepo;

    @PostMapping("/add")
    public ResponseEntity<String> addVegetable(@RequestBody Map<String, String> request) {
        Long farmerId = Long.parseLong(request.get("farmerId"));
        Farmer farmer = farmerRepo.findById(farmerId).orElse(null);
        if (farmer == null) return ResponseEntity.badRequest().body("Farmer not found");

        Vegetable veg = new Vegetable();
        veg.setName(request.get("name"));
        veg.setQuantity(Integer.parseInt(request.get("quantity")));
        veg.setPricePerKg(Double.parseDouble(request.get("pricePerKg")));
        veg.setFarmer(farmer);
        farmer.getVegetables().add(veg);
        farmerRepo.save(farmer);

        return ResponseEntity.ok("Vegetable added successfully.");
    }

    @GetMapping("/{name}")
    public List<Vegetable> getVegetablesByName(@PathVariable String name) {
        return vegetableRepo.findByNameIgnoreCase(name);
    }
}