package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitry.VegetableWarehouse.model.TypeWarehouse;

public interface TypeWarehouseRepository extends JpaRepository<TypeWarehouse, Long> {
}
