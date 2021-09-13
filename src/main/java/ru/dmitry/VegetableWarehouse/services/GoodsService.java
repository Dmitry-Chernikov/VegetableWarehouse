package ru.dmitry.VegetableWarehouse.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.mappers.GoodsMapper;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.repositories.GoodsRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsMapper mapper;
    @Autowired
    public GoodsService(GoodsRepository goodsRepository, GoodsMapper mapper) {
        this.goodsRepository = goodsRepository;
        this.mapper = mapper;
    }

    //Read id
    public Goods findById(Long id){
        return goodsRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Goods> findAll(){
        return goodsRepository.findAll();
    }
    //Save one unit
    public Goods save(Goods goods){
        return goodsRepository.save(goods);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            goodsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

    //Read id
    public GoodsDto findByIdDto(Long id){
        return mapper.toDto(goodsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<GoodsDto> findAllDto(){
        List<GoodsDto> goodsDto = new ArrayList<>();
        for (Goods goods: goodsRepository.findAll()) {
            goodsDto.add(mapper.toDto(goods));
        }
        return goodsDto;
    }
    //Save one unit
    public GoodsDto saveDto(GoodsDto goodsDto){
        return mapper.toDto(goodsRepository.save(mapper.toEntity(goodsDto)));
    }
    //Delete unit on id
    public void deleteBuIdDto(Long id){
        try{
            goodsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
