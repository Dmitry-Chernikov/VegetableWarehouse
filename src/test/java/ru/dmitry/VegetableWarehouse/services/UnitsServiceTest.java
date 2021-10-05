package ru.dmitry.VegetableWarehouse.services;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repositories.UnitsRepository;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
class UnitsServiceTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UnitsRepository unitsRepository;

    @Test
    void save() {
        Units units = new Units();
        units.setMeasurementUnit("Тонна");
        units.setDesignationUnit("т/t");

        entityManager.persist(units);
        entityManager.flush();

        unitsRepository.save(units);

        Assertions.assertThat(units.getId()).isGreaterThan(11L);
    }

    @Test
    void findById() {
        Units units = unitsRepository.findById(10L).get();
        Assertions.assertThat(units.getId()).isEqualTo(10L);
    }

    @Test
    void findAll() {
        List<Units> units = unitsRepository.findAll();
        Assertions.assertThat(units.size()).isGreaterThan(0);
    }

    @Test
    void update() {
        Units units = unitsRepository.findById(10L).get();
        units.setDesignationUnit("тест");
        Assertions.assertThat((unitsRepository.save(units)).getDesignationUnit()).isEqualTo("тест");
    }

    @Test
    void deleteById() {
        unitsRepository.delete(unitsRepository.getById(11L));
    }
}