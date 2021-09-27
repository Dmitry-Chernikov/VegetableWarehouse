package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.services.GoodsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"}, produces = "application/json")
@RequiredArgsConstructor
public class GoodsController {

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

    @DeleteMapping(path = "/goods/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGoods(@PathVariable("id") Long id) {
        goodsService.deleteById(id);
    }
}
