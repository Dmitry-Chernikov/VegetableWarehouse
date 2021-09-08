package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.service.UnitsService;
import ru.dmitry.VegetableWarehouse.service.UnitsServiceDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class UnitsControllerREST {

    private final UnitsServiceDto unitsServiceDto;

    //Получить все записи
    @GetMapping(path = "/units")
    public List<UnitsDto> getAllUnits() {
        return unitsServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/units/{id}")
    public ResponseEntity<UnitsDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<UnitsDto> unitsDto = Optional.ofNullable(unitsServiceDto.findById(id));
        return unitsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/units", consumes = "application/json")
    public UnitsDto postUnits(@RequestBody UnitsDto unitsDto) {
        return unitsServiceDto.save(unitsDto);
    }

    //Метод обновления
    @PutMapping(path = "/units/{id}")
    public UnitsDto putUnits(@RequestBody UnitsDto unitsDto) {
        return unitsServiceDto.save(unitsDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/units/{id}", consumes = "application/json")
    public UnitsDto patchUnits(@PathVariable("id") Long id, @RequestBody UnitsDto unitsDto) {
        UnitsDto unitsDtoRefresh = unitsServiceDto.findById(id);

        if (unitsDto.getMeasurementUnit() != null) {
            unitsDtoRefresh.setMeasurementUnit(unitsDto.getMeasurementUnit());
        }

        if (unitsDto.getDesignationUnit() != null) {
            unitsDtoRefresh.setDesignationUnit(unitsDto.getDesignationUnit());
        }

        return unitsServiceDto.save(unitsDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/units/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUnits(@PathVariable("id") Long id) {
        try {
            unitsServiceDto.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
