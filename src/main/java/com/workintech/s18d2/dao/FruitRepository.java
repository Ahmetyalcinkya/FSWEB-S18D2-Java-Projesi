package com.workintech.s18d2.dao;

import com.workintech.s18d2.entity.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FruitRepository extends JpaRepository<Fruit, Integer> {

    @Query("SELECT f FROM Fruit f WHERE f.fruitType = :fruitType")
    List<Fruit> findByFruitType(String fruitType);

    @Query(value = "SELECT f.name,f.price,f.fruit_type FROM fsweb.fruit AS f ORDER BY f.price DESC",
            nativeQuery = true)
    List<Fruit> sortByFruitPrice();

    @Query("SELECT f FROM Fruit f WHERE ILIKE %:name%")
    List<Fruit> searchByFruitName(String name);
}
