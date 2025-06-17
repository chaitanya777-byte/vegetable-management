package com.example.vegetable.service;

import com.example.vegetable.model.Farmer;
import com.example.vegetable.repository.FarmerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class FarmerService {
    @Autowired private FarmerRepository farmerRepo;
    public Farmer registerFarmer(String name) {
        return farmerRepo.save(new Farmer(null, name, new ArrayList<>()));
    }
}