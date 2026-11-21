package com.simmer.simmer_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Float calories;

    @Column(nullable = false)
    private Float proteins;

    @Column
    private Float carbs;

    @Column
    private Float fat;

    @ManyToMany
    @JoinTable(name = "ingredient_allergens", joinColumns = @JoinColumn(name = "ingredient_id"), inverseJoinColumns = @JoinColumn(name = "allergen_id"))
    private java.util.Set<Allergen> allergens = new java.util.HashSet<>();

    public Ingredient() {
    }

    public Ingredient(String name, Float calories, Float proteins) {
        this.name = name;
        this.calories = calories;
        this.proteins = proteins;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCalories() {
        return calories;
    }

    public void setCalories(Float calories) {
        this.calories = calories;
    }

    public Float getProteins() {
        return proteins;
    }

    public void setProteins(Float proteins) {
        this.proteins = proteins;
    }

    public Float getCarbs() {
        return carbs;
    }

    public void setCarbs(Float carbs) {
        this.carbs = carbs;
    }

    public Float getFat() {
        return fat;
    }

    public void setFat(Float fat) {
        this.fat = fat;
    }

    public java.util.Set<Allergen> getAllergens() {
        return allergens;
    }

    public void setAllergens(java.util.Set<Allergen> allergens) {
        this.allergens = allergens;
    }

}