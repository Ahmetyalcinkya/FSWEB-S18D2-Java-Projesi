package com.workintech.s18d2.dto;

import com.workintech.s18d2.entity.FruitType;

public record FruitResponseRecord(String name, Double price, FruitType fruitType) {
}
