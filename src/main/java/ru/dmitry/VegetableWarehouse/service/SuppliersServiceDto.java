package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.SuppliersMapper;
import ru.dmitry.VegetableWarehouse.dto.SuppliersDto;
import ru.dmitry.VegetableWarehouse.model.Suppliers;
import ru.dmitry.VegetableWarehouse.repo.SuppliersRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SuppliersServiceDto {

    private final SuppliersRepository suppliersRepository;
    private final SuppliersMapper mapper;
    //Read id
    public SuppliersDto findById(Long id){
        return mapper.toDto(suppliersRepository.findById(id).orElse(null));
    }
    //Read All
    public List<SuppliersDto> findAll(){
        List<SuppliersDto> suppliersDto = new ArrayList<>();
        for (Suppliers suppliers: suppliersRepository.findAll()) {
            suppliersDto.add(mapper.toDto(suppliers));
        }
        return suppliersDto;
    }
    //Save one unit
    public SuppliersDto save(SuppliersDto suppliersDto){
        return mapper.toDto(suppliersRepository.save(mapper.toEntity(suppliersDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            suppliersRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
