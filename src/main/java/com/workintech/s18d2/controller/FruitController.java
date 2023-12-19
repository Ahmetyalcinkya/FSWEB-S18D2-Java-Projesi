package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.FruitResponseRecord;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Validated
@RestController
@RequestMapping("/fruits")
public class FruitController {

    private FruitService fruitService;
    @Autowired
    public FruitController(FruitService fruitService) {
        this.fruitService = fruitService;
    }
    @GetMapping("/")
    public List<Fruit> allFruits(){
        return fruitService.allFruits();
    }
    @GetMapping("/{id}")
    public Fruit findFruitByID(@PathVariable int id){
        return fruitService.findFruitByID(id);
    }
    @GetMapping("/search/{name}")
    public List<Fruit> searchByFruitName(@PathVariable String name){
        return fruitService.searchByFruitName(name);
    }
    @GetMapping("/desc")
    public List<Fruit> sortByFruitPrice(){
        return fruitService.sortByFruitPrice();
    }
    @GetMapping("/search/type/{type}")
    public List<Fruit> findByFruitType(@PathVariable String fruitType){
        return fruitService.findByFruitType(fruitType);
    }
    @PostMapping("/")
    public Fruit addFruit(@RequestBody Fruit fruit){
        return fruitService.addFruit(fruit);
    }
    @DeleteMapping("/{id}")
    public FruitResponseRecord deleteFruit(@PathVariable int id){
        Fruit fruit = fruitService.findFruitByID(id);
        fruitService.deleteFruit(fruit.getId());
        return new FruitResponseRecord(fruit.getName(), fruit.getPrice(), fruit.getFruitType());
    }
}
