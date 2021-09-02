package ru.dmitry.VegetableWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
import ru.dmitry.VegetableWarehouse.service.TypeWarehouseService;

import java.util.List;

@Controller
public class TypeWarehouseController {

    private final TypeWarehouseService typeWarehouseService;

    @Autowired
    public TypeWarehouseController(TypeWarehouseService typeWarehouseService) {
        this.typeWarehouseService = typeWarehouseService;
    }
    
    @GetMapping("/type-warehouse")
    public String findAll(Model model){
        List<TypeWarehouse> typeWarehouse = typeWarehouseService.findAll();
        model.addAttribute("typeWarehouse", typeWarehouse);
        return "type-warehouse-list";
    }

    @GetMapping("/type-warehouse-create")
    public String createTypeWarehouseForm (TypeWarehouse typeWarehouse){
        return "type-warehouse-create";
    }

    @PostMapping("/type-warehouse-create")
    public String createTypeWarehouse(TypeWarehouse typeWarehouse){
        typeWarehouseService.saveUnits(typeWarehouse);
        return "redirect:/type-warehouse";
    }

    @GetMapping("type-warehouse-delete/{id}")
    public String deleteTypeWarehouse(@PathVariable("id") Long id){
        typeWarehouseService.deleteBuId(id);
        return "redirect:/type-warehouse";
    }

    @GetMapping("type-warehouse-update/{id}")
    public String updateTypeWarehouseForm (@PathVariable("id") Long id, Model model){
        TypeWarehouse typeWarehouse = typeWarehouseService.findById(id);
        model.addAttribute("typeWarehouse", typeWarehouse);
        return "/type-warehouse-update";
    }

    @PostMapping("/type-warehouse-update")
    public String updateUser(TypeWarehouse typeWarehouse){
        typeWarehouseService.saveUnits(typeWarehouse);
        return "redirect:/type-warehouse";
    }
}
