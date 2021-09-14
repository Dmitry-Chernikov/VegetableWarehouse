package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class UnitsControllerREST {

    private final UnitsService unitsService;

    @GetMapping(path = "/units")
    public List<UnitsDto> getAllUnits() {
        return unitsService.findAllDto();
    }

    @GetMapping(path = "/units/{id}")
    public ResponseEntity<UnitsDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<UnitsDto> unitsDto = Optional.ofNullable(unitsService.findByIdDto(id));
        return unitsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/units", consumes = "application/json")
    public UnitsDto createUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.saveDto(unitsDto);
    }

    @PutMapping(path = "/units/{id}")
    public UnitsDto updateUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.saveDto(unitsDto);
    }

    @PatchMapping(path = "/units/{id}", consumes = "application/json")
    public UnitsDto patchUnits(@PathVariable("id") Long id, @RequestBody @Validated UnitsDto unitsDto) {
        UnitsDto unitsDtoRefresh = unitsService.findByIdDto(id);

        if (unitsDto.getMeasurementUnit() != null) {
            unitsDtoRefresh.setMeasurementUnit(unitsDto.getMeasurementUnit());
        }

        if (unitsDto.getDesignationUnit() != null) {
            unitsDtoRefresh.setDesignationUnit(unitsDto.getDesignationUnit());
        }

        return unitsService.saveDto(unitsDtoRefresh);
    }

    @DeleteMapping(path = "/units/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUnits(@PathVariable("id") Long id) {
        try {
            unitsService.deleteBuIdDto(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
