package ru.dmitry.VegetableWarehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.VegetableWarehouse.model.Suppliers;
@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers, Long> {
}
