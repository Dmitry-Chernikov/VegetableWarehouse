package ru.dmitry.VegetableWarehouse.service;

import lombok.AllArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.converter.ProductsMapper;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.model.Products;
import ru.dmitry.VegetableWarehouse.repo.ProductsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductsServiceDto {
    private final ProductsRepository productsRepository;
    private final ProductsMapper mapper;
    //Read id
    public ProductsDto findById(Long id){
        return mapper.toDto(productsRepository.findById(id).orElse(null));
    }
    //Read All
    public List<ProductsDto> findAll(){
        List<ProductsDto> productsDto = new ArrayList<>();
        for (Products products: productsRepository.findAll()) {
            productsDto.add(mapper.toDto(products));
        }
        return productsDto;
    }
    //Save one unit
    public ProductsDto save(ProductsDto productsDto){
        return mapper.toDto(productsRepository.save(mapper.toEntity(productsDto)));
    }
    //Delete unit on id
    public void deleteBuId(Long id){
        try{
            productsRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){}
    }

}
