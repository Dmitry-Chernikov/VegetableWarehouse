package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
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
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Единицы измерения\" и используеться CRUD для базы данных.")
public class UnigtsController {

    private final UnitsService unitsService;

        @ApiOperation("Метод возвращает всех еденицы измерения использумые в овощебазе, хранящиеся в таблице \"Единицы измерения\"")
    @GetMapping(path = "/units")
    public List<UnitsDto> getAllUnits() {
        return unitsService.findAll();
    }

        @ApiOperation("Метод возвращает еденицу измерения по id из таблицы \"Единицы измерения\"")
    @GetMapping(path = "/units/{id}")
    public ResponseEntity<UnitsDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<UnitsDto> unitsDto = Optional.ofNullable(unitsService.findById(id));
        return unitsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

        @ApiOperation("Метод добовляет в таблиуц \"Единицы измерения\" новою еденицу измерения")
    @PostMapping(path = "/units")
    public UnitsDto createUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.save(unitsDto);
    }

        @ApiOperation("Метод изменяет атрибуты еденицы измерения хранящуюся в таблице \"Единицы измерения\"")
    @PutMapping(path = "/units/{id}")
    public UnitsDto updateUnits(@RequestBody UnitsDto unitsDto) {
        return unitsService.save(unitsDto);
    }

        @ApiOperation("Метод удаляет еденицу измерения по id из таблицы \"Единицы измерения\"")
    @DeleteMapping(path = "/units/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteUnits(@PathVariable("id") Long id) {
        unitsService.deleteById(id);
    }
}
