package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.service.UnitsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class UnitsControllerREST {

    private final UnitsService unitsService;

    //Получить все записи
    @GetMapping(path = "/unit")
    public Iterable<Units> getAllUnits() {
        return unitsService.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/unit/{id}")
    public ResponseEntity<Units> getUnitsById(@PathVariable("id") Long id) {
        Optional<Units> units = Optional.ofNullable(unitsService.findById(id));
        if (units.isPresent()) {
            return new ResponseEntity<>(units.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(path = "/unit", consumes = "application/json")
    public Units postUnits(@RequestBody Units units) {
        return unitsService.save(units);
    }

    //Метод обновления
    @PutMapping(path = "/unit/{id}")
    public Units putUnits(@RequestBody Units units) {
        return unitsService.save(units);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/unit/{id}", consumes = "application/json")
    public Units patchUnits(@PathVariable("id") Long id, @RequestBody Units units) {
        Units unitsRefresh = unitsService.findById(id);

        if (units.getMeasurementUnit() != null) {
            unitsRefresh.setMeasurementUnit(units.getMeasurementUnit());
        }

        if (units.getDesignationUnit() != null) {
            unitsRefresh.setDesignationUnit(units.getDesignationUnit());
        }

        return unitsService.save(unitsRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/unit/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUnits(@PathVariable("id") Long id) {
        try {
            unitsService.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
