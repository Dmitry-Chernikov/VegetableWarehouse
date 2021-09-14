package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class GoodsControllerREST {

    private final GoodsService goodsService;

    @GetMapping(path = "/goods")
    public Iterable<GoodsDto> getAllGoods() {
        return goodsService.findAllDto();
    }

    @GetMapping(path = "/goods/{id}")
    public ResponseEntity<GoodsDto> getGoodsById(@PathVariable("id") Long id) {
        Optional<GoodsDto> goodsDto = Optional.ofNullable(goodsService.findByIdDto(id));
        return goodsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/goods", consumes = "application/json")
    public GoodsDto createGoods(@RequestBody GoodsDto goodsDto) {
        return goodsService.saveDto(goodsDto);
    }

    @PutMapping(path = "/goods/{id}")
    public GoodsDto updateGoods(@RequestBody GoodsDto goodsDto) {
        return goodsService.saveDto(goodsDto);
    }
поля
    @PatchMapping(path = "/goods/{id}", consumes = "application/json")
    public GoodsDto updateCheckGoods(@PathVariable("id") Long id, @RequestBody @Validated GoodsDto goodsDto) {
        GoodsDto goodsDtoRefresh = goodsService.findByIdDto(id);

        if (goodsDto.getNameTypeVegetable() != null) {
            goodsDtoRefresh.setNameTypeVegetable(goodsDto.getNameTypeVegetable());
        }

        if (goodsDto.getVarietyName() != null) {
            goodsDtoRefresh.setVarietyName(goodsDto.getVarietyName());
        }

        if (goodsDto.getShelfLife() != null) {
            goodsDtoRefresh.setShelfLife(goodsDto.getShelfLife());
        }

        if (goodsDto.getDesignationUnit() != null) {
            goodsDtoRefresh.setDesignationUnit(goodsDto.getDesignationUnit());
        }

        if (goodsDto.getManufactureName() != null) {
            goodsDtoRefresh.setManufactureName(goodsDto.getManufactureName());
        }

        if (goodsDto.getManufactureCountry() != null) {
            goodsDtoRefresh.setManufactureCountry(goodsDto.getManufactureCountry());
        }

        return goodsService.saveDto(goodsDtoRefresh);
    }

    @DeleteMapping(path = "/goods/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGoods(@PathVariable("id") Long id) {
        goodsService.deleteBuIdDto(id);
    }
}
