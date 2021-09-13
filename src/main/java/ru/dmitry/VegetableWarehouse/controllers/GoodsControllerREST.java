package ru.dmitry.VegetableWarehouse.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.services.GoodsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class GoodsControllerREST {

    private final GoodsService goodsService;
    @Autowired
    public GoodsControllerREST(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    //Получить все записи
    @GetMapping(path = "/goods")
    public Iterable<GoodsDto> getAllGoods() {
        return goodsService.findAllDto();
    }

    //Получить записи по id
    @GetMapping(path = "/goods/{id}")
    public ResponseEntity<GoodsDto> getGoodsById(@PathVariable("id") Long id) {
        Optional<GoodsDto> goodsDto = Optional.ofNullable(goodsService.findByIdDto(id));
        return goodsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/goods", consumes = "application/json")
    public GoodsDto postGoods(@RequestBody GoodsDto goodsDto) {
        return goodsService.saveDto(goodsDto);
    }

    //Метод обновления
    @PutMapping(path = "/goods/{id}")
    public GoodsDto putGoods(@RequestBody GoodsDto goodsDto) {
        return goodsService.saveDto(goodsDto);
    }

    //Метод обновления с проверкой поля
/*    @PatchMapping(path = "/goods/{id}", consumes = "application/json")
    public GoodsDto patchGoods(@PathVariable("id") Long id, @RequestBody @Validated GoodsDto goodsDto) {
        GoodsDto goodsDtoRefresh = goodsService.findByIdDto(id);

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

        return goodsService.saveDto(goodsDtoRefresh);
    }*/

    //Метод удаления
    @DeleteMapping(path = "/goods/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGoods(@PathVariable("id") Long id) {
        try {
            goodsService.deleteBuIdDto(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
