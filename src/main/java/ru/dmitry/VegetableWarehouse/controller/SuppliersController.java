package ru.dmitry.VegetableWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Suppliers;
import ru.dmitry.VegetableWarehouse.service.SuppliersService;

import java.util.List;

@Controller
public class SuppliersController {

    private final SuppliersService suppliersService;
    @Autowired
    public SuppliersController(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    @GetMapping("/suppliers")
    public String findAll(Model model){
        List<Suppliers> suppliers = suppliersService.findAll();
        model.addAttribute("suppliers", suppliers);
        return "suppliers/suppliers-list";
    }

    @GetMapping("/suppliers-create")
    public String createSuppliersForm (Suppliers suppliers){
        return "suppliers/suppliers-create";
    }

    @PostMapping("/suppliers-create")
    public String createSuppliers(Suppliers suppliers){
        suppliersService.save(suppliers);
        return "redirect:/suppliers";
    }

    @GetMapping("suppliers-delete/{id}")
    public String deleteSuppliers(@PathVariable("id") Long id){
        suppliersService.deleteBuId(id);
        return "redirect:/suppliers";
    }

    @GetMapping("/suppliers-update/{id}")
    public String updateSuppliersForm (@PathVariable("id") Long id, Model model){
        Suppliers suppliers = suppliersService.findById(id);
        model.addAttribute("suppliers", suppliers);
        return "suppliers/suppliers-update";
    }

    @PostMapping("/suppliers-update")
    public String updateSuppliers(Suppliers suppliers){
        suppliersService.save(suppliers);
        return "redirect:/suppliers";
    }

}
