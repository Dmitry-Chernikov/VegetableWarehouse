package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.GoodsMapper;
import ru.dmitry.VegetableWarehouse.converter.UnitsMapper;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repo.GoodsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class GoodsServiceDto {
    private final GoodsRepository goodsRepository;
    private final GoodsMapper mapper;
    //Read id
    public GoodsDto findById(Long id){
        return mapper.toDto(goodsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<GoodsDto> findAll(){
        List<GoodsDto> goodsDto = new ArrayList<>();
        for (Goods goods: goodsRepository.findAll()) {
            goodsDto.add(mapper.toDto(goods));
        }
        return goodsDto;
    }
    //Save one unit
    public GoodsDto save(GoodsDto goodsDto){
        return mapper.toDto(goodsRepository.save(mapper.toEntity(goodsDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            goodsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
