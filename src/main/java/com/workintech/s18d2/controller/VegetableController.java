package com.workintech.s18d2.controller;

import com.workintech.s18d2.dto.VegetableResponseRecord;
import com.workintech.s18d2.entity.Vegetable;
import com.workintech.s18d2.service.VegetableService;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/vegetables")
public class VegetableController {

    private VegetableService vegetableService;

    public VegetableController(VegetableService vegetableService) {
        this.vegetableService = vegetableService;
    }

    @GetMapping("/")
    public List<Vegetable> allVegetables(){
        return vegetableService.allVegetables();
    }
    @GetMapping("/{id}")
    public VegetableResponseRecord findVegetableByID(@PathVariable int id){
        Vegetable vegetable = vegetableService.findVegetableByID(id);
        return new VegetableResponseRecord(vegetable.getName(),
                vegetable.getPrice(), vegetable.getIsGrownOnTree());
    }
    @GetMapping("/desc")
    public List<Vegetable> sortByVegetablePrice(){
        return vegetableService.sortByVegetablePrice();
    }
    @PostMapping("/searchByName/{name}")
    public List<Vegetable> searchByVegetableName(@Size(min = 2, max = 20) @PathVariable String name){
        return vegetableService.searchByVegetableName(name);
    }

    @PostMapping("/")
    public Vegetable addVegetable(@RequestBody Vegetable vegetable){
        return vegetableService.addVegetable(vegetable);
    }
    @DeleteMapping("/{id}")
    public VegetableResponseRecord deleteVegetable(@PathVariable int id){
        Vegetable vegetable = vegetableService.findVegetableByID(id);
        vegetableService.deleteVegetable(vegetable.getId());
        return new VegetableResponseRecord(vegetable.getName(), vegetable.getPrice(), vegetable.getIsGrownOnTree());
    }
}
