package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.BaseProductsMapper;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.repo.BaseProductsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BaseProductsServiceDto {

    private final BaseProductsRepository baseProductsRepository;
    private final BaseProductsMapper mapper;

    //Read id
    public BaseProductsDto findById(Long id){
        return mapper.toDto(baseProductsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<BaseProductsDto> findAll(){
        List<BaseProductsDto> baseProductsDto = new ArrayList<>();
        for (BaseProducts baseProducts: baseProductsRepository.findAll()) {
            baseProductsDto.add(mapper.toDto(baseProducts));
        }
        return baseProductsDto;
    }
    //Save one unit
    public BaseProductsDto save(BaseProductsDto baseProductsDto){
        return mapper.toDto(baseProductsRepository.save(mapper.toEntity(baseProductsDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            baseProductsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
