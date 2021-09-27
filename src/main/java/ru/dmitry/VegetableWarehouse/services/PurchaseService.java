package ru.dmitry.VegetableWarehouse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.dmitry.VegetableWarehouse.dto.PurchaseDto;
import ru.dmitry.VegetableWarehouse.mappers.PurchaseMapper;
import ru.dmitry.VegetableWarehouse.repositories.PurchaseRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final PurchaseMapper mapper;

    //Read id to Dto
    public PurchaseDto findById(Long id) {
        return mapper.toDto(purchaseRepository.findById(id).orElse(null));
    }

    //Read All to Dto
    public List<PurchaseDto> findAll() {
        return purchaseRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    //Save one unit and return Dto
    public PurchaseDto save(PurchaseDto purchaseDto) {
        return mapper.toDto(purchaseRepository.save(mapper.toEntity(purchaseDto)));
    }

    //Delete unit on id
    public void deleteById(Long id) {
        purchaseRepository.deleteById(id);
    }
}
