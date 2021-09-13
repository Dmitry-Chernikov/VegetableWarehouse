package ru.dmitry.VegetableWarehouse.controllers;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.services.SuppliersService;

import java.util.Optional;

@RestController
@RequestMapping(value = {"/api"}, produces = "application/json")
public class SuppliersControllerREST {

    private final SuppliersService suppliersService;
    @Autowired
    public SuppliersControllerREST(SuppliersService suppliersService) {
        this.suppliersService = suppliersService;
    }

    //Получить все записи
    @GetMapping("/suppliers")
    public Iterable<SuppliersDto> getAllSuppliers(){
        return suppliersService.findAllDto();
    }

    //Получить записи по id
    @GetMapping("/suppliers/{id}")
    public ResponseEntity<SuppliersDto> getSuppliersById(@PathVariable("id") Long id){
        Optional<SuppliersDto> suppliersDto = Optional.ofNullable(suppliersService.findByIdDto(id));
        return suppliersDto.map(dto -> new ResponseEntity<>(dto, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    //Метод добовления
    @PostMapping(consumes = "application/json", path = "/suppliers")
    public SuppliersDto postSuppliers(@RequestBody SuppliersDto suppliersDto){
        return suppliersService.saveDto(suppliersDto);
    }

    //Метод обновления
    @PutMapping("/suppliers/{id}")
    public SuppliersDto putSuppliers(@RequestBody SuppliersDto suppliersDto){
        return suppliersService.saveDto(suppliersDto);
    }

    //Метод обновления с проверкой поля
/*    @PatchMapping(path = "/suppliers/{id}",consumes = "application/json")
    public SuppliersDto patchSuppliers(@PathVariable("id") Long id, @RequestBody @Validated SuppliersDto suppliersDto){
        SuppliersDto suppliersDtoRefresh = suppliersService.findByIdDto(id);

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

        return suppliersService.saveDto(suppliersDtoRefresh);
    }*/

    //Метод удаления
    @DeleteMapping("/suppliers/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteSuppliers (@PathVariable("id") Long id){
        try{
            suppliersService.deleteBuIdDto(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
