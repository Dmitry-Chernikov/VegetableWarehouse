package ru.dmitry.VegetableWarehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.services.UnitsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class UnitsControllerREST {

    private final UnitsService unitsService;
    @Autowired
    public UnitsControllerREST(UnitsService unitsService) {
        this.unitsService = unitsService;
    }

    //Получить все записи
    @GetMapping(path = "/units")
    public ResponseEntity<List<UnitsDto>> getAllUnits() {
        return new ResponseEntity<>(unitsService.findAllDto(), HttpStatus.OK);
    }

    //Получить записи по id
    @GetMapping(path = "/units/{id}")
    public ResponseEntity<UnitsDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<UnitsDto> unitsDto = Optional.ofNullable(unitsService.findByIdDto(id));
        return unitsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/units", consumes = "application/json")
    public UnitsDto postUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.saveDto(unitsDto);
    }

    //Метод обновления
    @PutMapping(path = "/units/{id}")
    public UnitsDto putUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.saveDto(unitsDto);
    }

    //Метод обновления с проверкой поля
/*    @PatchMapping(path = "/units/{id}", consumes = "application/json")
    public UnitsDto patchUnits(@PathVariable("id") Long id, @RequestBody @Validated  UnitsDto unitsDto) {
        UnitsDto unitsDtoRefresh = unitsService.findByIdDto(id);

        if (unitsDto.getMeasurementUnit() != null) {
            unitsDtoRefresh.setMeasurementUnit(unitsDto.getMeasurementUnit());
        }

        if (unitsDto.getDesignationUnit() != null) {
            unitsDtoRefresh.setDesignationUnit(unitsDto.getDesignationUnit());
        }

        return unitsService.saveDto(unitsDtoRefresh);
    }*/

    //Метод удаления
    @DeleteMapping(path = "/units/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUnits(@PathVariable("id") Long id) {
        try {
            unitsService.deleteBuIdDto(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
