package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitry.VegetableWarehouse.model.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
