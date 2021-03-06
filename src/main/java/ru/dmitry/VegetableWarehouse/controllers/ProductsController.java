package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.services.ProductsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Продукты\" и используеться CRUD для базы данных.")
public class ProductsController {

    private final ProductsService productsService;

        @ApiOperation("Метод возвращает все продуткты тыблицы \"Продукты\"")
    @GetMapping(path = "/products")
    public Iterable<ProductsDto> getAllProducts() {
        return productsService.findAll();
    }

        @ApiOperation("Метод возвращает один продукт из таблицы \"Продукты\" по id")
    @GetMapping(path = "/products/{id}")
    public ResponseEntity<ProductsDto> getProductsById(@PathVariable("id") Long id) {
        Optional<ProductsDto> productsDto = Optional.ofNullable(productsService.findById(id));
        return productsDto.<ResponseEntity<ProductsDto>>map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

        @ApiOperation("Метод добовляет в таблицу \"Продукты\" один продукт")
    @PostMapping(path = "/products")
    public ProductsDto createProducts(@RequestBody ProductsDto productsDto) {
        return productsService.save(productsDto);
    }
        
        @ApiOperation("Метод изменяет атрибуты продукта в таблице \"Продукты\"")
    @PutMapping(path = "/products/{id}")
    public ProductsDto updateProducts(@RequestBody ProductsDto productsDto) {
        return productsService.save(productsDto);
    }

        @ApiOperation("Метод удаляет продукт из таблицы \"Продукты\" по id")
    @DeleteMapping(path = "/products/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProducts(@PathVariable("id") Long id) {
        productsService.deleteById(id);
    }
}
