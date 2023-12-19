package com.workintech.s18d2.service;

import com.workintech.s18d2.entity.Vegetable;

import java.util.List;

public interface VegetableService {

    List<Vegetable> allVegetables();
    Vegetable findVegetableByID(int id);
    List<Vegetable> sortByVegetablePrice();

    List<Vegetable> searchByVegetableName(String name);
    Vegetable addVegetable(Vegetable vegetable);

    Vegetable deleteVegetable(int id);
}
