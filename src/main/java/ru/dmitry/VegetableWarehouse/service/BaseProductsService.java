package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.BaseProducts;
import ru.dmitry.VegetableWarehouse.repo.BaseProductsRepository;

import java.util.List;
@Service
public class BaseProductsService {

    private final BaseProductsRepository baseProductsRepository;

    //Конструктор
    @Autowired
    public BaseProductsService(BaseProductsRepository baseProductsRepository) {
        this.baseProductsRepository = baseProductsRepository;
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
    public BaseProducts saveUnits(BaseProducts baseProducts){
        return baseProductsRepository.save(baseProducts);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            baseProductsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
