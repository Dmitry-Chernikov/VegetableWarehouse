package ru.dmitry.VegetableWarehouse.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.dmitry.VegetableWarehouse.model.Clients;

public interface ClientsRepository extends JpaRepository<Clients, Long> {
}
