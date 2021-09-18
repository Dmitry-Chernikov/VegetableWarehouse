package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class BaseProductsControllerREST {

    private final BaseProductsService baseProductsService;

    @GetMapping(path = "/baseProducts")
    public List<BaseProductsDto> getAllBaseProducts() {
        return baseProductsService.findAllDto();
    }

    @GetMapping(path = "/baseProducts/{id}")
    public ResponseEntity<BaseProductsDto> getBaseProductsById(@PathVariable("id") Long id) {
        Optional<BaseProductsDto> baseProductsDto = Optional.ofNullable(baseProductsService.findByIdDto(id));
        return baseProductsDto.map(productsDto -> new ResponseEntity<>(productsDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/baseProducts", consumes = "application/json")
    public BaseProductsDto createBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsService.saveDto(baseProductsDto);
    }

    @PutMapping(path = "/baseProducts/{id}")
    public BaseProductsDto updateBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsService.saveDto(baseProductsDto);
    }

    @PatchMapping(path = "/baseProducts/{id}", consumes = "application/json")
    public BaseProductsDto updateCheckBaseProducts(@PathVariable("id") Long id, @RequestBody @Validated BaseProductsDto baseProductsDto) {
        BaseProductsDto baseProductsDtoRefresh = baseProductsService.findByIdDto(id);

        if (baseProductsDto.getBarcode() != null) {
            baseProductsDtoRefresh.setBarcode(baseProductsDto.getBarcode());
        }

        if (baseProductsDto.getNameWarehouse() != null) {
            baseProductsDtoRefresh.setNameWarehouse(baseProductsDto.getNameWarehouse());
        }

        if (baseProductsDto.getVarietyName() != null) {
            baseProductsDtoRefresh.setVarietyName(baseProductsDto.getVarietyName());
        }

        return baseProductsService.saveDto(baseProductsDtoRefresh);
    }

    @DeleteMapping(path = "/baseProducts/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBaseProducts(@PathVariable("id") Long id) {
        baseProductsService.deleteBuIdDto(id);
    }

}
