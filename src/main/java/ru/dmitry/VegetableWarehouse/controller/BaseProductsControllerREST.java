package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.service.BaseProductsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class BaseProductsControllerREST {

    private final BaseProductsService baseProductsService;

    //Получить все записи
    @GetMapping(path = "/base-products")
    public Iterable<BaseProducts> getAllBaseProducts() {
        return baseProductsService.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/base-products/{id}")
    public ResponseEntity<BaseProducts> getBaseProductsById(@PathVariable("id") Long id) {
        Optional<BaseProducts> baseProducts = Optional.ofNullable(baseProductsService.findById(id));
        if (baseProducts.isPresent()) {
            return new ResponseEntity<>(baseProducts.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(path = "/base-products", consumes = "application/json")
    public BaseProducts postBaseProducts(@RequestBody BaseProducts baseProducts) {
        return baseProductsService.save(baseProducts);
    }

    //Метод обновления
    @PutMapping(path = "/base-products/{id}")
    public BaseProducts putBaseProducts(@RequestBody BaseProducts baseProducts) {
        return baseProductsService.save(baseProducts);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/base-products/{id}", consumes = "application/json")
    public BaseProducts patchBaseProducts(@PathVariable("id") Long id, @RequestBody BaseProducts baseProducts) {
        BaseProducts baseProductsRefresh = baseProductsService.findById(id);

        if (baseProducts.getBarcode() != null) {
            baseProductsRefresh.setBarcode(baseProducts.getBarcode());
        }

        if (baseProducts.getTypeWarehouse() != null) {
            baseProductsRefresh.setTypeWarehouse(baseProducts.getTypeWarehouse());
        }

        if (baseProducts.getGoods() != null) {
            baseProductsRefresh.setGoods(baseProducts.getGoods());
        }

        return baseProductsService.save(baseProductsRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/base-products/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBaseProducts(@PathVariable("id") Long id) {
        try {
            baseProductsService.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

}
