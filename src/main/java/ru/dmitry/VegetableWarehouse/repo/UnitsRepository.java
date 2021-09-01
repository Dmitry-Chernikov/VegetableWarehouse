package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitry.VegetableWarehouse.model.Units;

public interface UnitsRepository extends JpaRepository<Units, Long> {
}
