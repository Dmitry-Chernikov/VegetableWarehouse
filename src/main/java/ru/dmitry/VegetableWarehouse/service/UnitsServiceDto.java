package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.UnitsMapper;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repo.UnitsRepository;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class UnitsServiceDto {

    private final UnitsRepository unitsRepository;
    private final UnitsMapper mapper;
    //Read id
    public UnitsDto findById(Long id){
        return mapper.toDto(unitsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<UnitsDto> findAll(){
        List<UnitsDto> unitsDto = new ArrayList<>();
        for (Units units: unitsRepository.findAll()) {
            unitsDto.add(mapper.toDto(units));
        }
        return unitsDto;
    }
    //Save one unit
    public UnitsDto save(UnitsDto unitsDto){
        return mapper.toDto(unitsRepository.save(mapper.toEntity(unitsDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            unitsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
