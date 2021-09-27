package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.BaseProductsDto;
import ru.dmitry.VegetableWarehouse.mappers.BaseProductsMapper;
import ru.dmitry.VegetableWarehouse.repositories.BaseProductsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BaseProductsService {

    private final BaseProductsRepository baseProductsRepository;
    private final BaseProductsMapper mapper;

    //Read id to Dto
    public BaseProductsDto findById(Long id) {
        return mapper.toDto(baseProductsRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<BaseProductsDto> findAll() {
        return baseProductsRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public BaseProductsDto save(BaseProductsDto baseProductsDto) {
        return mapper.toDto(baseProductsRepository.save(mapper.toEntity(baseProductsDto)));
    }

    //Delete unit on id
    public void deleteById(Long id) {
        baseProductsRepository.deleteById(id);
    }
}
