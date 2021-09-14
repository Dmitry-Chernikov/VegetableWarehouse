package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.mappers.GoodsMapper;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.model.Products;
import ru.dmitry.VegetableWarehouse.repositories.GoodsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GoodsService {

    private final GoodsRepository goodsRepository;
    private final GoodsMapper mapper;

    //Read id
    public Goods findById(Long id) {
        return goodsRepository.findById(id).orElse(null);
    }

    //Read All
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    //Save one unit
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    //Delete unit on id
    public void deleteBuId(Long id) {
        try {
            goodsRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
        }
    }

    ///////////
    ////DTO////
    ///////////
    //Read id to Dto
    public GoodsDto findByIdDto(Long id) {
        return mapper.toDto(this.findById(id));
    }

    //Read All to Dto
    public List<GoodsDto> findAllDto() {
        List<GoodsDto> goodsDto = new ArrayList<>();
        for (Goods goods : this.findAll()) {
            goodsDto.add(mapper.toDto(goods));
        }
        return goodsDto;
    }

    //Save one unit and return Dto
    public GoodsDto saveDto(GoodsDto goodsDto) {
        return mapper.toDto(this.save(mapper.toEntity(goodsDto)));
    }

    //Delete unit on id
    public void deleteBuIdDto(Long id) {
        this.deleteBuId(id);
    }
}
