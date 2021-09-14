package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
import ru.dmitry.VegetableWarehouse.services.TypeWarehouseService;

@Controller
@RequiredArgsConstructor
public class TypeWarehouseController {

    private final TypeWarehouseService typeWarehouseService;

    @GetMapping("/type-warehouse")
    public String findAll(Model model) {
        model.addAttribute("typeWarehouse", typeWarehouseService.findAll());
        return "warehouse/type-warehouse-list";
    }

    @GetMapping("/type-warehouse-create")
    public String createTypeWarehouseForm(Model model) {
        model.addAttribute("typeWarehouse", new TypeWarehouse());
        return "warehouse/type-warehouse-create";
    }

    @PostMapping("/type-warehouse-create")
    public String createTypeWarehouse(TypeWarehouse typeWarehouse) {
        typeWarehouseService.save(typeWarehouse);
        return "redirect:/type-warehouse";
    }

    @GetMapping("type-warehouse-delete/{id}")
    public String deleteTypeWarehouse(@PathVariable("id") Long id) {
        typeWarehouseService.deleteBuId(id);
        return "redirect:/type-warehouse";
    }

    @GetMapping("type-warehouse-update/{id}")
    public String updateTypeWarehouseForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("typeWarehouse", typeWarehouseService.findById(id));
        return "warehouse/type-warehouse-update";
    }

    @PostMapping("/type-warehouse-update")
    public String updateTypeWarehouse(TypeWarehouse typeWarehouse) {
        typeWarehouseService.save(typeWarehouse);
        return "redirect:/type-warehouse";
    }
}
