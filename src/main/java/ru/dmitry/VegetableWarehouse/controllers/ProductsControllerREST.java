package ru.dmitry.VegetableWarehouse.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.services.ProductsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class ProductsControllerREST {

    private final ProductsService productsService;
    @Autowired
    public ProductsControllerREST(ProductsService productsService) {
        this.productsService = productsService;
    }

    //Получить все записи
    @GetMapping(path = "/products")
    public Iterable<ProductsDto> getAllProducts() {
        return productsService.findAllDto();
    }

    //Получить записи по id
    @GetMapping(path = "/products/{id}")
    public ResponseEntity<ProductsDto> getProductsById(@PathVariable("id") Long id) {
        Optional<ProductsDto> productsDto = Optional.ofNullable(productsService.findByIdDto(id));
        return productsDto.<ResponseEntity<ProductsDto>>map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/products", consumes = "application/json")
    public ProductsDto postProducts(@RequestBody ProductsDto productsDto) {
        return productsService.saveDto(productsDto);
    }

    //Метод обновления
    @PutMapping(path = "/products/{id}")
    public ProductsDto putProducts(@RequestBody ProductsDto productsDto) {
        return productsService.saveDto(productsDto);
    }

    //Метод обновления с проверкой поля
/*    @PatchMapping(path = "/products/{id}", consumes = "application/json")
    public ProductsDto patchProducts(@PathVariable("id") Long id, @RequestBody @Validated ProductsDto productsDto) {
        ProductsDto productsDtoRefresh = productsService.findByIdDto(id);

        if (productsDto.getNameTypeVegetable() != null) {
            productsDtoRefresh.setNameTypeVegetable(productsDto.getNameTypeVegetable());
        }

        return productsService.saveDto(productsDtoRefresh);
    }*/

    //Метод удаления
    @DeleteMapping(path = "/products/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProducts(@PathVariable("id") Long id) {
        try {
            productsService.deleteBuIdDto(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
