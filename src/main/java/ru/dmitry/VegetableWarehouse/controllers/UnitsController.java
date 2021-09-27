package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.services.UnitsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/"}, produces = "application/json")
@RequiredArgsConstructor
public class UnitsController {

    private final UnitsService unitsService;

    @GetMapping(path = "/units")
    public List<UnitsDto> getAllUnits() {
        return unitsService.findAll();
    }

    @GetMapping(path = "/units/{id}")
    public ResponseEntity<UnitsDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<UnitsDto> unitsDto = Optional.ofNullable(unitsService.findById(id));
        return unitsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/units", consumes = "application/json")
    public UnitsDto createUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.save(unitsDto);
    }

    @PutMapping(path = "/units/{id}")
    public UnitsDto updateUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.save(unitsDto);
    }

    @DeleteMapping(path = "/units/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUnits(@PathVariable("id") Long id) {
        unitsService.deleteById(id);
    }
}
