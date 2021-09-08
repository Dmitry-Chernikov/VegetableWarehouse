package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.SalesMapper;
import ru.dmitry.VegetableWarehouse.dto.SalesDto;
import ru.dmitry.VegetableWarehouse.model.Sales;
import ru.dmitry.VegetableWarehouse.repo.SalesRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SalesServiceDto {
    private final SalesRepository salesRepository;
    private final SalesMapper mapper;
    //Read id
    public SalesDto findById(Long id){
        return mapper.toDto(salesRepository.findById(id).orElse(null));
    }
    //Read All
    public List<SalesDto> findAll(){
        List<SalesDto> salesDto = new ArrayList<>();
        for (Sales sales: salesRepository.findAll()) {
            salesDto.add(mapper.toDto(sales));
        }
        return salesDto;
    }
    //Save one unit
    public SalesDto save(SalesDto salesDto){
        return mapper.toDto(salesRepository.save(mapper.toEntity(salesDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            salesRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

}

