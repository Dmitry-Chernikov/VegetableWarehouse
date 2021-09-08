package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.service.PurchaseServiceDto;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor
public class PurchaseControllerREST {

    private final PurchaseServiceDto purchaseServiceDto;

    //Получить все записи
    @GetMapping(path = "/purchase")
    public Iterable<PurchaseDto> getAllPurchase() {
        return purchaseServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping(path = "/purchase/{id}")
    public ResponseEntity<PurchaseDto> getUnitsById(@PathVariable("id") Long id) {
        Optional<PurchaseDto> purchaseDto = Optional.ofNullable(purchaseServiceDto.findById(id));
        return purchaseDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(path = "/purchase", consumes = "application/json")
    public PurchaseDto postPurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseServiceDto.save(purchaseDto);
    }

    //Метод обновления
    @PutMapping(path = "/purchase/{id}")
    public PurchaseDto putPurchase(@RequestBody PurchaseDto purchaseDto) {
        return purchaseServiceDto.save(purchaseDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/purchase/{id}", consumes = "application/json")
    public PurchaseDto patchPurchase(@PathVariable("id") Long id, @RequestBody PurchaseDto purchaseDto) {
        PurchaseDto purchaseDtoRefresh = purchaseServiceDto.findById(id);

        if (purchaseDto.getBarcode() != null) {
            purchaseDtoRefresh.setBarcode(purchaseDto.getBarcode());
        }

//        if (purchaseDto.getBaseProducts() != null) {
//            purchaseDtoRefresh.setBaseProducts(purchaseDto.getBaseProducts());
//        }

        //if (purchaseDto.getCountProduct() != null) {
        //    purchaseDtoRefresh.setCountProduct(purchaseDto.getCountProduct());
        //}

        if (purchaseDto.getSuppliersName() != null) {
            purchaseDtoRefresh.setSuppliersName(purchaseDto.getSuppliersName());
        }

//        if (purchaseDto.getSuppliers() != null) {
//            purchaseDtoRefresh.setSuppliers(purchaseDto.getSuppliers());
//        }

//        if (purchaseDto.getEmployee() != null) {
//            purchaseDtoRefresh.setEmployee(purchaseDto.getEmployee());
//        }

        if (purchaseDto.getOperationDate() != null) {
            purchaseDtoRefresh.setOperationDate(purchaseDto.getOperationDate());
        }

        //if (purchaseDto.getValuePrice() != null) {
        //    purchaseDtoRefresh.setValuePrice(purchaseDto.getValuePrice());
        //}
        return purchaseServiceDto.save(purchaseDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping(path = "/purchase/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deletePurchase(@PathVariable("id") Long id) {
        try {
            purchaseServiceDto.deleteBuId(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }
}
