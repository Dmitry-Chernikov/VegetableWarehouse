package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.Products;
import ru.dmitry.VegetableWarehouse.service.ProductsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class ProductsControllerREST {

    private final ProductsService productsService;

    //Получить все записи
    @GetMapping(path = "/products")
    public Iterable<Products> getAllProducts() {
        return productsService.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/products/{id}")
    public ResponseEntity<Products> getProductsById(@PathVariable("id") Long id) {
        Optional<Products> products = Optional.ofNullable(productsService.findById(id));
        if (products.isPresent()) {
            return new ResponseEntity<>(products.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(path = "/products", consumes = "application/json")
    public Products postProducts(@RequestBody Products products) {
        return productsService.save(products);
    }

    //Метод обновления
    @PutMapping(path = "/products/{id}")
    public Products putProducts(@RequestBody Products products) {
        return productsService.save(products);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/products/{id}", consumes = "application/json")
    public Products patchProducts(@PathVariable("id") Long id, @RequestBody Products products) {
        Products productsRefresh = productsService.findById(id);

        if (products.getNameTypeVegetable() != null) {
            productsRefresh.setNameTypeVegetable(products.getNameTypeVegetable());
        }

        return productsService.save(productsRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/products/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteProducts(@PathVariable("id") Long id) {
        try {
            productsService.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
