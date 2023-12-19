package com.workintech.s18d2.service;

import com.workintech.s18d2.dao.VegetableRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.exceptions.FruitException;
import com.workintech.s18d2.exceptions.VegetableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VegetableServiceImpl implements VegetableService {

    private VegetableRepository vegetableRepository;
    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository) {
        this.vegetableRepository = vegetableRepository;
    }

    @Override
    public List<Vegetable> allVegetables() {
        return vegetableRepository.findAll();
    }

    @Override
    public Vegetable findVegetableByID(int id) {

        Optional<Vegetable> optional = vegetableRepository.findById(id);

        if(optional.isPresent()){
            return optional.get();
        }
        throw new VegetableException("Girdiğiniz id değerli kullanıcı bulanamadı.", HttpStatus.NOT_FOUND);
    }

    @Override
    public List<Vegetable> sortByVegetablePrice() {

        return vegetableRepository.sortByVegetablePrice();
    }

    @Override
    public List<Vegetable> searchByVegetableName(String name) {
        return vegetableRepository.searchByVegetableName(name);
    }

    @Override
    public Vegetable addVegetable(Vegetable vegetable) {
        return vegetableRepository.save(vegetable);
    }

    @Override
    public Vegetable deleteVegetable(int id) {
        Vegetable vegetable = findVegetableByID(id);
        vegetableRepository.deleteById(vegetable.getId());
        return vegetable;
    }
}
