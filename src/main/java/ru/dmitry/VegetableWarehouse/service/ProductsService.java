package ru.dmitry.VegetableWarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.model.Products;
import ru.dmitry.VegetableWarehouse.repo.ProductsRepository;

import java.util.List;
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;

    //Конструктор
    @Autowired
    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    //Read id
    public Products findById(Long id){
        return productsRepository.findById(id).orElse(null);
    }
    //Read All
    public List<Products> findAll(){
        return productsRepository.findAll();
    }
    //Save one unit
    public Products saveUnits(Products products){
        return productsRepository.save(products);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            productsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
