package ru.dmitry.VegetableWarehouse.services;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.mappers.ProductsMapper;
import ru.dmitry.VegetableWarehouse.model.Products;
import ru.dmitry.VegetableWarehouse.repositories.ProductsRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductsMapper mapper;
    @Autowired
    public ProductsService(ProductsRepository productsRepository, ProductsMapper mapper) {
        this.productsRepository = productsRepository;
        this.mapper = mapper;
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
    public Products save(Products products){
        return productsRepository.save(products);
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            productsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }


    //Read id
    public ProductsDto findByIdDto(Long id){
        return mapper.toDto(productsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<ProductsDto> findAllDto(){
        List<ProductsDto> productsDto = new ArrayList<>();
        for (Products products: productsRepository.findAll()) {
            productsDto.add(mapper.toDto(products));
        }
        return productsDto;
    }
    //Save one unit
    public ProductsDto saveDto(ProductsDto productsDto){
        return mapper.toDto(productsRepository.save(mapper.toEntity(productsDto)));
    }
    //Delete unit on id
    public void deleteBuIdDto(Long id){
        try{
            productsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }
}
