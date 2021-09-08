package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.TypeWarehouseMapper;
import ru.dmitry.VegetableWarehouse.dto.TypeWarehouseDto;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;
import ru.dmitry.VegetableWarehouse.repo.TypeWarehouseRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TypeWarehouseServiceDto {
    private final TypeWarehouseRepository typeWarehouseRepository;
    private final TypeWarehouseMapper mapper;
    //Read id
    public TypeWarehouseDto findById(Long id){
        return mapper.toDto(typeWarehouseRepository.findById(id).orElse(null));
    }
    //Read All
    public List<TypeWarehouseDto> findAll(){
        List<TypeWarehouseDto> typeWarehouseDto = new ArrayList<>();
        for (TypeWarehouse typeWarehouse: typeWarehouseRepository.findAll()) {
            typeWarehouseDto.add(mapper.toDto(typeWarehouse));
        }
        return typeWarehouseDto;
    }
    //Save one unit
    public TypeWarehouseDto save(TypeWarehouseDto typeWarehouseDto){
        return mapper.toDto(typeWarehouseRepository.save(mapper.toEntity(typeWarehouseDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            typeWarehouseRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
