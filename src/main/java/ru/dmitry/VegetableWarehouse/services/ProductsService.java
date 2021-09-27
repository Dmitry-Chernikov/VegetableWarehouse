package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.ProductsDto;
import ru.dmitry.VegetableWarehouse.mappers.ProductsMapper;
import ru.dmitry.VegetableWarehouse.repositories.ProductsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;
    private final ProductsMapper mapper;

    //Read id to Dto
    public ProductsDto findById(Long id) {
        return mapper.toDto(productsRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<ProductsDto> findAll() {
        return productsRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public ProductsDto save(ProductsDto productsDto) {
        return mapper.toDto(productsRepository.save(mapper.toEntity(productsDto)));
    }

    //Delete unit on id
    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }
}
