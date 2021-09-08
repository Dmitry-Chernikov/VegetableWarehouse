package ru.dmitry.VegetableWarehouse.controller;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.model.Suppliers;
import ru.dmitry.VegetableWarehouse.service.SuppliersServiceDto;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
@AllArgsConstructor //
public class SuppliersControllerREST {

    private final SuppliersServiceDto suppliersServiceDto;

    //Получить все записи
    @GetMapping("/suppliers")
    public Iterable<SuppliersDto> getAllSuppliers(){
        return suppliersServiceDto.findAll();
    }

    //Получить записи по id
    @GetMapping("/suppliers/{id}")
    public ResponseEntity<SuppliersDto> getSuppliersById(@PathVariable("id") Long id){
        Optional<SuppliersDto> suppliersDto = Optional.ofNullable(suppliersServiceDto.findById(id));
        return suppliersDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(consumes = "application/json", path = "/suppliers")
    public SuppliersDto postSuppliers(@RequestBody SuppliersDto suppliersDto){
        return suppliersServiceDto.save(suppliersDto);
    }

    //Метод обновления
    @PutMapping("/suppliers/{id}")
    public SuppliersDto putSuppliers(@RequestBody SuppliersDto suppliersDto){
        return suppliersServiceDto.save(suppliersDto);
    }

    //Метод обновления с проверкой поля
    @PatchMapping(path = "/suppliers/{id}",consumes = "application/json")
    public SuppliersDto patchSuppliers(@PathVariable("id") Long id, @RequestBody SuppliersDto suppliersDto){
        SuppliersDto suppliersDtoRefresh = suppliersServiceDto.findById(id);

        if(suppliersDto.getName() != null){
            suppliersDtoRefresh.setName(suppliersDto.getName());
        }

        if(suppliersDto.getCodeUNP() != null){
            suppliersDtoRefresh.setCodeUNP(suppliersDto.getCodeUNP());
        }

        if(suppliersDto.getLegalAddress() != null){
            suppliersDtoRefresh.setLegalAddress(suppliersDto.getLegalAddress());
        }

        if(suppliersDto.getTelephoneNumber() != null){
            suppliersDtoRefresh.setTelephoneNumber(suppliersDto.getTelephoneNumber());
        }

        if(suppliersDto.getFullName() != null){
            suppliersDtoRefresh.setFullName(suppliersDto.getFullName());
        }

        if(suppliersDto.getWorkingPosition() != null){
            suppliersDtoRefresh.setWorkingPosition(suppliersDto.getWorkingPosition());
        }

        return suppliersServiceDto.save(suppliersDtoRefresh);
    }

    //Метод удаления
    @DeleteMapping("/suppliers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSuppliers (@PathVariable("id") Long id){
        try{
            suppliersServiceDto.deleteBuId(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
