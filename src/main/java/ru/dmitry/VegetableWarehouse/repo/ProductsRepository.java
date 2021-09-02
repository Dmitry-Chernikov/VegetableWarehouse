package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitry.VegetableWarehouse.model.Products;

public interface ProductsRepository extends JpaRepository<Products, Long> {
}
