package ru.dmitry.VegetableWarehouse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.services.BaseProductsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class BaseProductsControllerREST {

    private final BaseProductsService baseProductsService;
    @Autowired
    public BaseProductsControllerREST(BaseProductsService baseProductsService) {
        this.baseProductsService = baseProductsService;
    }

    //Получить все записи
    @GetMapping(path = "/base-products")
    public List<BaseProductsDto> getAllBaseProducts() {
        return baseProductsService.findAllDto();
    }

    //Получить записи по id
    @GetMapping(path = "/base-products/{id}")
    public ResponseEntity<BaseProductsDto> getBaseProductsById(@PathVariable("id") Long id) {
        Optional<BaseProductsDto> baseProductsDto = Optional.ofNullable(baseProductsService.findByIdDto(id));
        return baseProductsDto.map(productsDto -> new ResponseEntity<>(productsDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/base-products", consumes = "application/json")
    public BaseProductsDto postBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsService.saveDto(baseProductsDto);
    }

    //Метод обновления
    @PutMapping(path = "/base-products/{id}")
    public BaseProductsDto putBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsService.saveDto(baseProductsDto);
    }

    //Метод обновления с проверкой поля
/*    @PatchMapping(path = "/base-products/{id}", consumes = "application/json")
    public BaseProductsDto patchBaseProducts(@PathVariable("id") Long id, @RequestBody @Validated BaseProductsDto baseProductsDto) {
        BaseProductsDto baseProductsDtoRefresh = baseProductsService.findByIdDto(id);

        if (baseProductsDto.getBarcode() != null) {
            baseProductsDtoRefresh.setBarcode(baseProductsDto.getBarcode());
        }

//        if (baseProductsDto.getTypeWarehouse() != null) {
//            baseProductsDtoRefresh.setTypeWarehouse(baseProductsDto.getTypeWarehouse());
//        }

//        if (baseProductsDto.getGoods() != null) {
//            baseProductsDtoRefresh.setGoods(baseProductsDto.getGoods());
//        }

        return baseProductsService.saveDto(baseProductsDtoRefresh);
    }*/

    //Метод удаления
    @DeleteMapping(path = "/base-products/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBaseProducts(@PathVariable("id") Long id) {
        try {
            baseProductsService.deleteBuIdDto(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

}
