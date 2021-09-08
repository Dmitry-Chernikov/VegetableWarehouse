package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.model.Products;
import ru.dmitry.VegetableWarehouse.service.ProductsServiceDto;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class ProductsControllerREST {

    private final ProductsServiceDto productsServiceDto;

    //Получить все записи
    @GetMapping(path = "/products")
    public Iterable<ProductsDto> getAllProducts() {
        return productsServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/products/{id}")
    public ResponseEntity<ProductsDto> getProductsById(@PathVariable("id") Long id) {
        Optional<ProductsDto> productsDto = Optional.ofNullable(productsServiceDto.findById(id));
        return productsDto.<ResponseEntity<ProductsDto>>map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/products", consumes = "application/json")
    public ProductsDto postProducts(@RequestBody ProductsDto productsDto) {
        return productsServiceDto.save(productsDto);
    }

    //Метод обновления
    @PutMapping(path = "/products/{id}")
    public ProductsDto putProducts(@RequestBody ProductsDto productsDto) {
        return productsServiceDto.save(productsDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/products/{id}", consumes = "application/json")
    public ProductsDto patchProducts(@PathVariable("id") Long id, @RequestBody ProductsDto productsDto) {
        ProductsDto productsDtoRefresh = productsServiceDto.findById(id);

        if (productsDto.getNameTypeVegetable() != null) {
            productsDtoRefresh.setNameTypeVegetable(productsDto.getNameTypeVegetable());
        }

        return productsServiceDto.save(productsDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/products/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProducts(@PathVariable("id") Long id) {
        try {
            productsServiceDto.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
