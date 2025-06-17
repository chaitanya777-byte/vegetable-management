package com.example.vegetable.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Farmer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "farmer", cascade = CascadeType.ALL)
    private List<Vegetable> vegetables = new ArrayList<>();

    public Farmer() {}
    public Farmer(Long id, String name, List<Vegetable> vegetables) {
        this.id = id; this.name = name; this.vegetables = vegetables;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<Vegetable> getVegetables() { return vegetables; }
    public void setVegetables(List<Vegetable> vegetables) { this.vegetables = vegetables; }
}