package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.service.GoodsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class GoodsControllerREST {
    private final GoodsService goodsService;

    //Получить все записи
    @GetMapping(path = "/goods")
    public Iterable<Goods> getAllGoods() {
        return goodsService.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/goods/{id}")
    public ResponseEntity<Goods> getGoodsById(@PathVariable("id") Long id) {
        Optional<Goods> goods = Optional.ofNullable(goodsService.findById(id));
        if (goods.isPresent()) {
            return new ResponseEntity<>(goods.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    //Метод добовления
    @PostMapping(path = "/goods", consumes = "application/json")
    public Goods postGoods(@RequestBody Goods goods) {
        return goodsService.save(goods);
    }

    //Метод обновления
    @PutMapping(path = "/goods/{id}")
    public Goods putGoods(@RequestBody Goods goods) {
        return goodsService.save(goods);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/goods/{id}", consumes = "application/json")
    public Goods patchGoods(@PathVariable("id") Long id, @RequestBody Goods goods) {
        Goods goodsRefresh = goodsService.findById(id);

        if (goods.getProducts() != null) {
            goodsRefresh.setProducts(goods.getProducts());
        }

        if (goods.getVarietyName() != null) {
            goodsRefresh.setVarietyName(goods.getVarietyName());
        }

        if (goods.getShelfLife() != null) {
            goodsRefresh.setShelfLife(goods.getShelfLife());
        }

        if (goods.getUnits() != null) {
            goodsRefresh.setUnits(goods.getUnits());
        }

        if (goods.getManufactureName() != null) {
            goodsRefresh.setManufactureName(goods.getManufactureName());
        }

        if (goods.getManufactureCountry() != null) {
            goodsRefresh.setManufactureCountry(goods.getManufactureCountry());
        }

        return goodsService.save(goodsRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/goods/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGoods(@PathVariable("id") Long id) {
        try {
            goodsService.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
