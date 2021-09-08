package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.service.GoodsServiceDto;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class GoodsControllerREST {
    private final GoodsServiceDto goodsServiceDto;

    //Получить все записи
    @GetMapping(path = "/goods")
    public Iterable<GoodsDto> getAllGoods() {
        return goodsServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/goods/{id}")
    public ResponseEntity<GoodsDto> getGoodsById(@PathVariable("id") Long id) {
        Optional<GoodsDto> goodsDto = Optional.ofNullable(goodsServiceDto.findById(id));
        return goodsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/goods", consumes = "application/json")
    public GoodsDto postGoods(@RequestBody GoodsDto goodsDto) {
        return goodsServiceDto.save(goodsDto);
    }

    //Метод обновления
    @PutMapping(path = "/goods/{id}")
    public GoodsDto putGoods(@RequestBody GoodsDto goodsDto) {
        return goodsServiceDto.save(goodsDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/goods/{id}", consumes = "application/json")
    public GoodsDto patchGoods(@PathVariable("id") Long id, @RequestBody GoodsDto goodsDto) {
        GoodsDto goodsDtoRefresh = goodsServiceDto.findById(id);

//        if (goodsDto.getProducts() != null) {
//            goodsDtoRefresh.setProducts(goodsDto.getProducts());
//        }

        if (goodsDto.getVarietyName() != null) {
            goodsDtoRefresh.setVarietyName(goodsDto.getVarietyName());
        }

        if (goodsDto.getShelfLife() != null) {
            goodsDtoRefresh.setShelfLife(goodsDto.getShelfLife());
        }

//        if (goodsDto.getUnits() != null) {
//            goodsDtoRefresh.setUnits(goodsDto.getUnits());
//        }

        if (goodsDto.getManufactureName() != null) {
            goodsDtoRefresh.setManufactureName(goodsDto.getManufactureName());
        }

        if (goodsDto.getManufactureCountry() != null) {
            goodsDtoRefresh.setManufactureCountry(goodsDto.getManufactureCountry());
        }

        return goodsServiceDto.save(goodsDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/goods/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGoods(@PathVariable("id") Long id) {
        try {
            goodsServiceDto.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
