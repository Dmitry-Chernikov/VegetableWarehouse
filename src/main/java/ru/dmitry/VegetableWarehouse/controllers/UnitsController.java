package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.services.UnitsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Единицы измерения\" и используется CRUD для базы данных.")
public class UnitsController {

    private final UnitsService unitsService;

        @ApiOperation("Метод возвращает всех единицы измерения используемые в овощебазе, хранящиеся в таблице \"Единицы измерения\"")
    @GetMapping(path = "/units")
    public List<UnitsDto> getAllUnits() {
        return unitsService.findAll();
    }

        @ApiOperation("Метод возвращает единицу измерения по id из таблицы \"Единицы измерения\"")
    @GetMapping(path = "/units/{id}")
    public ResponseEntity<UnitsDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<UnitsDto> unitsDto = Optional.ofNullable(unitsService.findById(id));
        return unitsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

        @ApiOperation("Метод добавляет в таблицу \"Единицы измерения\" новою единицу измерения")
    @PostMapping(path = "/units")
    public UnitsDto createUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.save(unitsDto);
    }

        @ApiOperation("Метод изменяет атрибуты единицы измерения хранящуюся в таблице \"Единицы измерения\"")
    @PutMapping(path = "/units/{id}")
    public UnitsDto updateUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.save(unitsDto);
    }

        @ApiOperation("Метод удаляет единицу измерения по id из таблицы \"Единицы измерения\"")
    @DeleteMapping(path = "/units/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUnits(@PathVariable("id") Long id) {
        unitsService.deleteById(id);
    }
}
