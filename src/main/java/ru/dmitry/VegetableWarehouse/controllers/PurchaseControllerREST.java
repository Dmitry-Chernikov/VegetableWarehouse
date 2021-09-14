package ru.dmitry.VegetableWarehouse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.services.PurchaseService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@RequiredArgsConstructor
public class PurchaseControllerREST {

    private final PurchaseService purchaseService;

    @GetMapping(path = "/purchase")
    public Iterable<PurchaseDto> getAllPurchase() {
        return purchaseService.findAllDto();
    }

    @GetMapping(path = "/purchase/{id}")
    public ResponseEntity<PurchaseDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<PurchaseDto> purchaseDto = Optional.ofNullable(purchaseService.findByIdDto(id));
        return purchaseDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    @PostMapping(path = "/purchase", consumes = "application/json")
    public PurchaseDto createPurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.saveDto(purchaseDto);
    }

    @PutMapping(path = "/purchase/{id}")
    public PurchaseDto updatePurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseService.saveDto(purchaseDto);
    }

    @PatchMapping(path = "/purchase/{id}", consumes = "application/json")
    public PurchaseDto updateCheckPurchase(@PathVariable("id") Long id, @RequestBody @Validated PurchaseDto purchaseDto) {
        PurchaseDto purchaseDtoRefresh = purchaseService.findByIdDto(id);

        if (purchaseDto.getBarcode() != null) {
            purchaseDtoRefresh.setBarcode(purchaseDto.getBarcode());
        }

        if (purchaseDto.getNameTypeVegetable() != null) {
            purchaseDtoRefresh.setNameTypeVegetable(purchaseDto.getNameTypeVegetable());
        }

        if (purchaseDto.getCountProduct() != 0.0) {
            purchaseDtoRefresh.setCountProduct(purchaseDto.getCountProduct());
        }

        if (purchaseDto.getSuppliersName() != null) {
            purchaseDtoRefresh.setSuppliersName(purchaseDto.getSuppliersName());
        }

        if (purchaseDto.getSuppliersName() != null) {
            purchaseDtoRefresh.setSuppliersName(purchaseDto.getSuppliersName());
        }

        if (purchaseDto.getName() != null) {
            purchaseDtoRefresh.setName(purchaseDto.getName());
        }

        if (purchaseDto.getFullName() != null) {
            purchaseDtoRefresh.setFullName(purchaseDto.getFullName());
        }

        if (purchaseDto.getOperationDate() != null) {
            purchaseDtoRefresh.setOperationDate(purchaseDto.getOperationDate());
        }

        if (purchaseDto.getValuePrice() != 0.0) {
            purchaseDtoRefresh.setValuePrice(purchaseDto.getValuePrice());
        }
        return purchaseService.saveDto(purchaseDtoRefresh);
    }

    @DeleteMapping(path = "/purchase/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePurchase(@PathVariable("id") Long id) {
        purchaseService.deleteBuIdDto(id);
    }
}

