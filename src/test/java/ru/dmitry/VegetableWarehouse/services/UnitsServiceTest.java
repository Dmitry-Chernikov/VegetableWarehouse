package ru.dmitry.VegetableWarehouse.services;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.mappers.UnitsMapper;
import ru.dmitry.VegetableWarehouse.repositories.UnitsRepository;

//@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
class UnitsServiceTest {
    @InjectMocks
    private UnitsService unitsService;

    @Mock
    private UnitsMapper mapper;

    @Mock
    private UnitsRepository unitsRepository;

/*    @TestConfiguration
    static class UnitsServiceTestContextConfiguration {
        @Bean
        public UnitsService unitsService() {
            return new UnitsService();
        }
    }*/

    @Before
    public void setUp() {
        //Mockito.when(unitsRepository.getById(10L)).thenReturn(units);
        MockitoAnnotations.initMocks(this);
    }

 /*   @Test
    public void save() throws Exception {
        UnitsDto unitsDto = new UnitsDto();
        unitsDto.setId(11L);
        unitsDto.setMeasurementUnit("Тонна");
        unitsDto.setDesignationUnit("т/t");

        this.unitsRepository.save(this.mapper.toEntity(unitsDto));
        //unitsDto = unitsService.findById(11L);
        Assertions.assertThat(unitsDto.getId()).isGreaterThan(0L);
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
        UnitsDto unitsDto = new UnitsDto();
        unitsDto = this.unitsService.findById(2L);
        Mockito.verify(unitsRepository).findById(2l);

        Assertions.assertThat(unitsDto.getDesignationUnit()).isEqualTo("ц");
        this.unitsService.deleteById(10L);
    }*/
}