package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.services.ProductsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"}, produces = "application/json")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping(path = "/products")
    public Iterable<ProductsDto> getAllProducts() {
        return productsService.findAll();
    }

    @GetMapping(path = "/products/{id}")
    public ResponseEntity<ProductsDto> getProductsById(@PathVariable("id") Long id) {
        Optional<ProductsDto> productsDto = Optional.ofNullable(productsService.findById(id));
        return productsDto.<ResponseEntity<ProductsDto>>map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/products", consumes = "application/json")
    public ProductsDto createProducts(@RequestBody ProductsDto productsDto) {
        return productsService.save(productsDto);
    }

    @PutMapping(path = "/products/{id}")
    public ProductsDto updateProducts(@RequestBody ProductsDto productsDto) {
        return productsService.save(productsDto);
    }

    @DeleteMapping(path = "/products/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProducts(@PathVariable("id") Long id) {
        productsService.deleteById(id);
    }
}
