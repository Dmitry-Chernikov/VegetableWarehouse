package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.mappers.TypeWarehouseMapper;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
import ru.dmitry.VegetableWarehouse.repositories.TypeWarehouseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TypeWarehouseService {

    private final TypeWarehouseRepository typeWarehouseRepository;
    private final TypeWarehouseMapper mapper;

    //Read id
    public TypeWarehouse findById(Long id) {
        return typeWarehouseRepository.findById(id).orElse(null);
    }

    //Read All
    public List<TypeWarehouse> findAll() {
        return typeWarehouseRepository.findAll();
    }

    //Save one unit
    public TypeWarehouse save(TypeWarehouse typeWarehouse) {
        return typeWarehouseRepository.save(typeWarehouse);
    }

    //Delete unit on id
    public void deleteBuId(Long id) {
        try {
            typeWarehouseRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }


    ///////////
    ////DTO////
    ///////////
    //Read id to Dto
    public TypeWarehouseDto findByIdDto(Long id) {
        return mapper.toDto(typeWarehouseRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<TypeWarehouseDto> findAllDto() {
        return typeWarehouseRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public TypeWarehouseDto saveDto(TypeWarehouseDto typeWarehouseDto) {
        return mapper.toDto(this.save(mapper.toEntity(typeWarehouseDto)));
    }

    //Delete unit on id
    public void deleteBuIdDto(Long id) {
        this.deleteBuId(id);
    }
}
