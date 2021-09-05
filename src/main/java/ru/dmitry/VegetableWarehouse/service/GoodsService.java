package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.repo.GoodsRepository;

import java.util.List;
@Service
public class GoodsService {

    private final GoodsRepository goodsRepository;

    //Конструктор
    @Autowired
    public GoodsService(GoodsRepository goodsRepository) {
        this.goodsRepository = goodsRepository;
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
}
