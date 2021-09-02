package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitry.VegetableWarehouse.model.Suppliers;

public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {
}
