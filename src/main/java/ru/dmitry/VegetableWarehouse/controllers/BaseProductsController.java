package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.services.BaseProductsService;

import java.util.List;
import java.util.Optional;


/**
 * Repository to manage {@link ResponseEntity} instances.
 *
 * @author Dmitry Chernikov
 */

@RestController
@RequestMapping(value = {"/"}, produces = "application/json")
@RequiredArgsConstructor
public class BaseProductsController {

    private final BaseProductsService baseProductsService;

    @GetMapping(path = "/baseProducts")
    public List<BaseProductsDto> getAllBaseProducts() {
        return baseProductsService.findAll();
    }

    @GetMapping(path = "/baseProducts/{id}")
    public ResponseEntity<BaseProductsDto> getBaseProductsById(@PathVariable("id") Long id) {
        Optional<BaseProductsDto> baseProductsDto = Optional.ofNullable(baseProductsService.findById(id));
        return baseProductsDto.map(productsDto -> new ResponseEntity<>(productsDto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/baseProducts", consumes = "application/json")
    public BaseProductsDto createBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsService.save(baseProductsDto);
    }

    @PutMapping(path = "/baseProducts/{id}")
    public BaseProductsDto updateBaseProducts(@RequestBody BaseProductsDto baseProductsDto) {
        return baseProductsService.save(baseProductsDto);
    }

    @DeleteMapping(path = "/baseProducts/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteBaseProducts(@PathVariable("id") Long id) {
        baseProductsService.deleteById(id);
    }

}
