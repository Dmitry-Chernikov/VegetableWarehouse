package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.services.GoodsService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Товары\" и используеться CRUD для базы данных.")
public class GoodsController {

    private final GoodsService goodsService;

        @ApiOperation("Метод возвращает все товары из таблицы \"Товары\"")
    @GetMapping(path = "/goods")
    public Iterable<GoodsDto> getAllGoods() {
        return goodsService.findAllDto();
    }
        @ApiOperation("Метод возвращает один товар из таблицы \"Товары\" по id")
    @GetMapping(path = "/goods/{id}")
    public ResponseEntity<GoodsDto> getGoodsById(@PathVariable("id") Long id) {
        Optional<GoodsDto> goodsDto = Optional.ofNullable(goodsService.findByIdDto(id));
        return goodsDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
        @ApiOperation("Метод создаёт в таблице \"Товары\" один товар")
    @PostMapping(path = "/goods")
    public GoodsDto createGoods(@RequestBody GoodsDto goodsDto) {
        return goodsService.saveDto(goodsDto);
    }
        @ApiOperation("Метод изменяет атрибуты товара в таблице \"Товары\"")
    @PutMapping(path = "/goods/{id}")
    public GoodsDto updateGoods(@RequestBody GoodsDto goodsDto) {
        return goodsService.saveDto(goodsDto);
    }
        @ApiOperation("Метод удаляет товар из таблицы \"Товары\" по id")
    @DeleteMapping(path = "/goods/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteGoods(@PathVariable("id") Long id) {
        goodsService.deleteById(id);
    }
}
