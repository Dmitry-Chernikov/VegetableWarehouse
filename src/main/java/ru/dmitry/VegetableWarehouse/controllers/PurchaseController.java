package ru.dmitry.VegetableWarehouse.controllers;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.services.PurchaseService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/"})
@RequiredArgsConstructor
@Api(description = "Контроллер реализует REST стандарт для работы с таблицей \"Расходные накладные\" и используеться CRUD для базы данных.")
public class PurchaseController {

    private final PurchaseService purchaseService;

        @ApiOperation("Метод возвращает всех служащих овощебазы")
    @GetMapping(path = "/purchase")
    public Iterable<PurchaseDto> getAllPurchase() {
        return purchaseService.findAll();
    }

        @ApiOperation("Метод возвращает одну накладную из таблицы \"Расходные накладные\" овощебазы по id")
    @GetMapping(path = "/purchase/{id}")
    public ResponseEntity<PurchaseDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<PurchaseDto> purchaseDto = Optional.ofNullable(purchaseService.findById(id));
        return purchaseDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

        @ApiOperation("Метод добвляет в таблице \"Расходные накладные\" накладную")
    @PostMapping(path = "/purchase")
    public PurchaseDto createPurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.save(purchaseDto);
    }

        @ApiOperation("Метод изменяет атрибуты накладной в таблице \"Расходные накладные\"")
    @PutMapping(path = "/purchase/{id}")
    public PurchaseDto updatePurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.save(purchaseDto);
    }

        @ApiOperation("Метод удаляет накладную из таблицы \"Расходные накладные\" по id")
    @DeleteMapping(path = "/purchase/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePurchase(@PathVariable("id") Long id) {
        purchaseService.deleteById(id);
    }
}

