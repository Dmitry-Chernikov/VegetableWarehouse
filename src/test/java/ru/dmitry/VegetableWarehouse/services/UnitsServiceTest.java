package ru.dmitry.VegetableWarehouse.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.mappers.UnitsMapper;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repositories.UnitsRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@SpringBootTest
class UnitsServiceTest {

    @Mock //создаёт фиктивную реализацию
    private UnitsMapper mapper;

    @Mock
    private UnitsRepository unitsRepository;

    @InjectMocks //создаёт макет реализации, дополнительно вводит в него фиктивные реализации
    private UnitsService unitsService =  new UnitsService(unitsRepository, mapper);

    @BeforeEach // Выполнять пред каждым
    public void init() {
        List<Units> unitsList = new ArrayList<Units>();//unitsRepository.findAll();
        Units unitsOne = new Units();
        Units unitsTwo = new Units();
        unitsOne.setId(1L);
        unitsOne.setMeasurementUnit("Российский рубль");
        unitsOne.setDesignationUnit("руб");
        unitsTwo.setId(2L);
        unitsTwo.setMeasurementUnit("Доллар США");
        unitsTwo.setDesignationUnit("USD");

        unitsList.add(unitsOne);
        unitsList.add(unitsTwo);
        when(unitsRepository.findAll()).thenReturn(unitsList);
    }


    @DisplayName("Тест Mock findAll")
    @Test
    public void findAll() {
        List<UnitsDto> unitsDto = unitsService.findAll();
        assertEquals(2, unitsDto.size());
        verify(unitsRepository, times(1)).findAll();
    }
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
