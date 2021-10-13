package ru.dmitry.VegetableWarehouse.services;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.mappers.UnitsMapper;
import ru.dmitry.VegetableWarehouse.model.Units;
import ru.dmitry.VegetableWarehouse.repositories.UnitsRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

//@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@SpringBootTest
class UnitsServiceTest {
    @Mock
    //@MockBean //создаёт фиктивную реализацию
    private UnitsMapper mapper;

    @Mock
    //@MockBean
    private UnitsRepository unitsRepository;

    //@InjectMocks //создаёт макет реализации, дополнительно вводит в него фиктивные реализации
    @Autowired
    private UnitsService unitsService;


    @BeforeEach // Выполнять пред каждым
    public void init() {
        //MockitoAnnotations.initMocks(this);
        //List<Units> unitsList = new ArrayList<Units>();//unitsRepository.findAll();
/*
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
*/
        //when(unitsRepository.findAll()).thenReturn(unitsList);
        //unitsService = new UnitsService(this.unitsRepository,this.mapper);


    }


    @DisplayName("Тест findAllTest")
    @Test
    public void findAllTest() {
        //when(unitsRepository.findAll()).thenReturn(unitsList);
        List<UnitsDto> unitsDtoList = unitsService.findAll();
        assertEquals(unitsService.findAll().size(), unitsDtoList.size());
    }

    @DisplayName("Тест saveTest")
    @Test
    public void saveTest() {
        UnitsDto unitsDto = new UnitsDto();
        unitsDto.setId(23L);
        unitsDto.setMeasurementUnit("Евро");
        unitsDto.setDesignationUnit("EUR");

        unitsService.save(unitsDto);

        assertEquals(unitsService.findById(23L).getDesignationUnit(), unitsDto.getDesignationUnit());
    }


    @DisplayName("Тест updateTest")
    @Test
    void updateTest() {
        UnitsDto unitsDto = unitsService.findById(23L);
        unitsDto.setDesignationUnit("тест");
        unitsService.save(unitsDto);
        assertEquals(unitsService.findById(23L).getDesignationUnit(), unitsDto.getDesignationUnit());
    }


    @DisplayName("Тест finByIdTest")
    @Test
    void findByIdTest() {
        UnitsDto unitsDto = unitsService.findById(23L);
        assertEquals(unitsDto.getId().longValue(), 23L);
    }


    @DisplayName("Тест deleteByIdTest")
    @Test
    void deleteByIdTest() {
        if (isNull() != unitsService.findById(23L)) {
            unitsService.deleteById(23L);
            return;
        }
        assertEquals(unitsService.findById(23L), isNull(), "Строка не найдена");
    }
}