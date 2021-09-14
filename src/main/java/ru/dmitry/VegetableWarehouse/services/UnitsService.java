package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.mappers.UnitsMapper;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repositories.UnitsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UnitsService {

    private final UnitsRepository unitsRepository;
    private final UnitsMapper mapper;

    //Read id
    public Units findById(Long id) {
        return unitsRepository.findById(id).orElse(null);
    }

    //Read All
    public List<Units> findAll() {
        return unitsRepository.findAll();
    }

    //Save one unit
    public Units save(Units units) {
        return unitsRepository.save(units);
    }

    //Delete unit on id
    public void deleteBuId(Long id) {
        try {
            unitsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    ///////////
    ////DTO////
    ///////////
    //Read id to Dto
    public UnitsDto findByIdDto(Long id) {
        return mapper.toDto(this.findById(id));
    }

    //Read All to Dto
    public List<UnitsDto> findAllDto() {
        List<UnitsDto> unitsDto = new ArrayList<>();
        for (Units units : this.findAll()) {
            unitsDto.add(mapper.toDto(units));
        }
        return unitsDto;
    }

    //Save one unit and return Dto
    public UnitsDto saveDto(UnitsDto unitsDto) {
        return mapper.toDto(this.save(mapper.toEntity(unitsDto)));
    }

    //Delete unit on id
    public void deleteBuIdDto(Long id) {
        this.deleteBuId(id);
    }
}
