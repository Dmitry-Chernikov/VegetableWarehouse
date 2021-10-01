package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.services.BaseProductsService;

import java.util.List;
import java.util.Optional;


/**
 * Repository to manage {@link ResponseEntity} instances.
 *
 * @author Dmitry Chernikov
 */

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(tags = "Контроллер для работы с сущьностью База продуктов", description = "Контроллер реализует REST стандарт для работы с таблицей \"База продуктов\" и используеться CRUD для базы данных.")
public class BaseProductsController {

    private final BaseProductsService baseProductsService;

        @ApiOperation("Метод возвращает все продукты на складе")
    @GetMapping(path = "/baseProducts")
    public List<BaseProductsDto> getAllBaseProducts() {
        return baseProductsService.findAll();
    }

        @ApiOperation("Метод возвращает продукт по id")
    @GetMapping(path = "/baseProducts/{id}")
    public ResponseEntity<BaseProductsDto> getBaseProductsById(@PathVariable("id") Long id) {
        Optional<BaseProductsDto> baseProductsDto = Optional.ofNullable(baseProductsService.findById(id));
        return baseProductsDto.map(productsDto -> new ResponseEntity<>(productsDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

        @ApiOperation("Метод создаёт в таблице База продуктоа продукт")
    @PostMapping(path = "/baseProducts")
    public BaseProductsDto createBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsService.save(baseProductsDto);
    }

        @ApiOperation("Метод изменяет продукт в таблице База продуктов")
    @PutMapping(path = "/baseProducts/{id}")
    public BaseProductsDto updateBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsService.save(baseProductsDto);
    }

        @ApiOperation("Метод удаляет продукт по id")
    @DeleteMapping(path = "/baseProducts/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBaseProducts(@PathVariable("id") Long id) {
        baseProductsService.deleteById(id);
    }

}
