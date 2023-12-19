package com.workintech.s18d2.service;

import com.workintech.s18d2.dao.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.FruitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService {

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository) {
        this.fruitRepository = fruitRepository;
    }

    @Override
    public List<Fruit> allFruits() {
        return fruitRepository.findAll();
    }

    @Override
    public Fruit findFruitByID(int id) {
        Optional<Fruit> optional = fruitRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        throw new FruitException("Girdiğiniz id değerli kullanıcı bulanamadı.", HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Fruit> findByFruitType(String fruitType) {
        return fruitRepository.findByFruitType(fruitType);
    }

    @Override
    public List<Fruit> sortByFruitPrice() {
        return fruitRepository.sortByFruitPrice();
    }

    @Override
    public List<Fruit> searchByFruitName(String name) {
        return fruitRepository.searchByFruitName(name);
    }

    @Override
    public Fruit addFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    @Override
    public Fruit deleteFruit(int id) {
        Fruit fruit = findFruitByID(id);
        fruitRepository.deleteById(fruit.getId());
        return fruit;
    }
}
