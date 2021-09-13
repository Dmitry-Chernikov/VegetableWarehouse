package ru.dmitry.VegetableWarehouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.dmitry.VegetableWarehouse.model.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
