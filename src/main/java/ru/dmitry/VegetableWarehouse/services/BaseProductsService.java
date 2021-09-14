package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.dto.ClientsDto;
import ru.dmitry.VegetableWarehouse.mappers.BaseProductsMapper;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.model.Clients;
import ru.dmitry.VegetableWarehouse.repositories.BaseProductsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseProductsService {

    private final BaseProductsRepository baseProductsRepository;
    private final BaseProductsMapper mapper;

    //Read id
    public BaseProducts findById(Long id) {
        return baseProductsRepository.findById(id).orElse(null);
    }

    //Read All
    public List<BaseProducts> findAll() {
        return baseProductsRepository.findAll();
    }

    //Save one unit
    public BaseProducts save(BaseProducts baseProducts) {
        return baseProductsRepository.save(baseProducts);
    }

    //Delete unit on id
    public void deleteBuId(Long id) {
        try {
            baseProductsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    ///////////
    ////DTO////
    ///////////
    //Read id to Dto
    public BaseProductsDto findByIdDto(Long id) {
        return mapper.toDto(this.findById(id));
    }

    //Read All to Dto
    public List<BaseProductsDto> findAllDto() {
        List<BaseProductsDto> baseProductsDto = new ArrayList<>();
        for (BaseProducts baseProducts : this.findAll()) {
            baseProductsDto.add(mapper.toDto(baseProducts));
        }
        return baseProductsDto;
    }

    //Save one unit and return Dto
    public BaseProductsDto saveDto(BaseProductsDto baseProductsDto) {
        return mapper.toDto(this.save(mapper.toEntity(baseProductsDto)));
    }

    //Delete unit on id
    public void deleteBuIdDto(Long id) {
        this.deleteBuId(id);
    }
}
