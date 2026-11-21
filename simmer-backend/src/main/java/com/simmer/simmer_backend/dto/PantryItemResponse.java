package com.simmer.simmer_backend.dto;

import java.time.LocalDate;

public class PantryItemResponse {
    private Long id;
    private Long ingredientId;
    private String ingredientName;
    private Float calories;
    private Float quantity;
    private Long unitId;
    private String unitName;
    private LocalDate expirationDate;

    public PantryItemResponse(Long id, Long ingredientId, String ingredientName, Float calories,
            Float quantity, Long unitId, String unitName, LocalDate expirationDate) {
        this.id = id;
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.calories = calories;
        this.quantity = quantity;
        this.unitId = unitId;
        this.unitName = unitName;
        this.expirationDate = expirationDate;
    }

    public Long getId() {
        return id;
    }

    public Long getIngredientId() {
        return ingredientId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public Float getCalories() {
        return calories;
    }

    public Float getQuantity() {
        return quantity;
    }

    public Long getUnitId() {
        return unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }
}