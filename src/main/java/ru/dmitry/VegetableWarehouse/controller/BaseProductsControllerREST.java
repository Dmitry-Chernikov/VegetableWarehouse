package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.service.BaseProductsServiceDto;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class BaseProductsControllerREST {

    private final BaseProductsServiceDto baseProductsServiceDto;

    //Получить все записи
    @GetMapping(path = "/base-products")
    public Iterable<BaseProductsDto> getAllBaseProducts() {
        return baseProductsServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/base-products/{id}")
    public ResponseEntity<BaseProductsDto> getBaseProductsById(@PathVariable("id") Long id) {
        Optional<BaseProductsDto> baseProductsDto = Optional.ofNullable(baseProductsServiceDto.findById(id));
        return baseProductsDto.map(productsDto -> new ResponseEntity<>(productsDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/base-products", consumes = "application/json")
    public BaseProductsDto postBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsServiceDto.save(baseProductsDto);
    }

    //Метод обновления
    @PutMapping(path = "/base-products/{id}")
    public BaseProductsDto putBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsServiceDto.save(baseProductsDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/base-products/{id}", consumes = "application/json")
    public BaseProductsDto patchBaseProducts(@PathVariable("id") Long id, @RequestBody BaseProductsDto baseProductsDto) {
        BaseProductsDto baseProductsDtoRefresh = baseProductsServiceDto.findById(id);

        if (baseProductsDto.getBarcode() != null) {
            baseProductsDtoRefresh.setBarcode(baseProductsDto.getBarcode());
        }

//        if (baseProductsDto.getTypeWarehouse() != null) {
//            baseProductsDtoRefresh.setTypeWarehouse(baseProductsDto.getTypeWarehouse());
//        }

//        if (baseProductsDto.getGoods() != null) {
//            baseProductsDtoRefresh.setGoods(baseProductsDto.getGoods());
//        }

        return baseProductsServiceDto.save(baseProductsDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/base-products/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBaseProducts(@PathVariable("id") Long id) {
        try {
            baseProductsServiceDto.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

}
