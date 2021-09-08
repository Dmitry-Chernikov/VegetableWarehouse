package ru.dmitry.VegetableWarehouse.converter;

import ru.dmitry.VegetableWarehouse.dto.AbstractDto;
import ru.dmitry.VegetableWarehouse.model.BaseEntity;

public interface Mapper<E extends BaseEntity, D extends AbstractDto> {
    E toEntity (D dto);
    D toDto(E entity);
}
