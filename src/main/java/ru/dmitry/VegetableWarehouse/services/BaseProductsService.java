package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.mappers.BaseProductsMapper;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.repositories.BaseProductsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaseProductsService {

    private final BaseProductsRepository baseProductsRepository;
    private final BaseProductsMapper mapper;
    @Autowired
    public BaseProductsService(BaseProductsRepository baseProductsRepository, BaseProductsMapper mapper) {
        this.baseProductsRepository = baseProductsRepository;
        this.mapper = mapper;
    }

    //Read id
    public BaseProducts findById(Long id){
        return baseProductsRepository.findById(id).orElse(null);
    }
    //Read All
    public List<BaseProducts> findAll(){
        return baseProductsRepository.findAll();
    }
    //Save one unit
    public BaseProducts save(BaseProducts baseProducts){
        return baseProductsRepository.save(baseProducts);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            baseProductsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

    //Read id
    public BaseProductsDto findByIdDto(Long id){
        return mapper.toDto(baseProductsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<BaseProductsDto> findAllDto(){
        List<BaseProductsDto> baseProductsDto = new ArrayList<>();
        for (BaseProducts baseProducts: baseProductsRepository.findAll()) {
            baseProductsDto.add(mapper.toDto(baseProducts));
        }
        return baseProductsDto;
    }
    //Save one unit
    public BaseProductsDto saveDto(BaseProductsDto baseProductsDto){
        return mapper.toDto(baseProductsRepository.save(mapper.toEntity(baseProductsDto)));
    }
    //Delete unit on id
    public void deleteBuIdDto(Long id){
        try{
            baseProductsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
