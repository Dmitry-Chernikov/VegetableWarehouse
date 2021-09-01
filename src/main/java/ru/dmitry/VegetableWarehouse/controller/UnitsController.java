package ru.dmitry.VegetableWarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.service.UnitsService;

import java.util.List;

@Controller
public class UnitsController {
    private final UnitsService unitsService;
    @Autowired
    public UnitsController(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    @GetMapping("/units")
    public String findAll(Model model){
        List<Units> units = unitsService.findAll();
        model.addAttribute("units", units);
        return "units-list";
    }

    @GetMapping("/unit-create")
    public String createUnitsForm (Units units){
        return "unit-create";
    }

    @PostMapping
    public String createUnits(Units units){
        unitsService.saveUnits(units);
        return "redirect:/units";
    }
}
