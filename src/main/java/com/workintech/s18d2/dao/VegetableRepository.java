package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Vegetable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VegetableRepository extends JpaRepository<Vegetable, Integer> {

    @Query("SELECT v FROM Vegetable v ORDER BY v.price desc")
    List<Vegetable> sortByVegetablePrice();
    @Query("SELECT f FROM Fruit f WHERE f.name ILIKE %:name%")
    List<Vegetable> searchByVegetableName(String name);
}
