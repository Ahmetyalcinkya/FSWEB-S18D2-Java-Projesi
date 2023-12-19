package com.workintech.s18d2.service;

import com.workintech.s18d2.entity.Fruit;

import java.util.List;

public interface FruitService {

    //get
    List<Fruit> allFruits();
    Fruit findFruitByID(int id);
    List<Fruit> sortByFruitPrice();
    List<Fruit> searchByFruitName(String name);
    List<Fruit> findByFruitType(String fruitType);

    //post
    Fruit addFruit(Fruit fruit);

    //delete
    Fruit deleteFruit(int id);

}
