package ru.dmitry.VegetableWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.service.UnitsService;

@Controller
public class UnitsController {
    private final UnitsService unitsService;
    @Autowired
    public UnitsController(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    @GetMapping("/units")
    public String findAll(Model model){
        model.addAttribute("units", unitsService.findAll());
        return "units/units-list";
    }

    @GetMapping("/unit-create")
    public String createUnitsForm (Model model){
        model.addAttribute("units", new Units());
        return "units/unit-create";
    }

    @PostMapping("/unit-create")
    public String createUnits(Units units){
        unitsService.save(units);
        return "redirect:/units";
    }

    @GetMapping("unit-delete/{id}")
    public String deleteUnits(@PathVariable("id") Long id){
        unitsService.deleteBuId(id);
        return "redirect:/units";
    }

    @GetMapping("/unit-update/{id}")
    public String updateUnitsForm (@PathVariable("id") Long id, Model model){
        model.addAttribute("unit", unitsService.findById(id));
        return "units/unit-update";
    }

    @PostMapping("/unit-update")
    public String updateUnits(Units units){
        unitsService.save(units);
        return "redirect:/units";
    }
}
