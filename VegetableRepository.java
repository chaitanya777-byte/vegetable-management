package com.example.vegetable.repository;

import com.example.vegetable.model.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Long> {
    List<Vegetable> findByNameIgnoreCase(String name);
}