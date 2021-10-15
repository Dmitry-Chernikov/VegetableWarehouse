package ru.dmitry.VegetableWarehouse.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.dmitry.VegetableWarehouse.dto.UnitsDto;
import ru.dmitry.VegetableWarehouse.mappers.UnitsMapper;
import ru.dmitry.VegetableWarehouse.repositories.UnitsRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.isNull;

//@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
//@RunWith(SpringRunner.class)
//@ExtendWith(SpringExtension.class)
@SpringBootTest
//@DataJpaTest
class UnitsServiceTest {

    @Mock
    //@MockBean //создаёт фиктивную реализацию
    //@Autowired
    private UnitsMapper mapper; //= Mockito.mock(UnitsMapper.class);

    //@Mock
    //@MockBean
    @Autowired
    private UnitsRepository unitsRepository; // = Mockito.mock(UnitsRepository.class);

    @Autowired
    //@InjectMocks //создаёт макет реализации, дополнительно вводит в него фиктивные реализации
    private UnitsService unitsService = new UnitsService(unitsRepository, mapper);
    private long id = 27;


    @BeforeEach // Выполнять пред каждым
    public void init() {
    }

    @AfterEach
    public void tearDown() {
    }

    @DisplayName("Тест saveTest")
    @Test
    public void saveTest() {
        UnitsDto unitsDto = new UnitsDto();
        unitsDto.setMeasurementUnit("Евро");
        unitsDto.setDesignationUnit("EUR");
        unitsDto = unitsService.save(unitsDto);
        id = unitsDto.getId();
        assertEquals(unitsService.findById(unitsDto.getId()).getDesignationUnit(), unitsRepository.findById(unitsDto.getId()).get().getDesignationUnit());
    }

    @DisplayName("Тест findAllTest")
    @Test
    public void findAllTest() {
        assertEquals(this.unitsRepository.findAll(), this.unitsService.findAll());
    }

    @DisplayName("Тест updateTest")
    @Test
    void updateTest() {
        UnitsDto unitsDto = unitsService.findById(id);
        unitsDto.setDesignationUnit("тест");
        unitsService.save(unitsDto);
        assertEquals(unitsService.findById(id).getDesignationUnit(), unitsRepository.findById(id).get().getDesignationUnit());
    }


    @DisplayName("Тест finByIdTest")
    @Test
    void findByIdTest() {
        assertEquals(unitsService.findById(id).getId(), unitsRepository.findById(id).get().getId());
    }


    @DisplayName("Тест deleteByIdTest")
    @Test
    void deleteByIdTest() {
        if (isNull() != unitsService.findById(id)) {
            unitsService.deleteById(id);
            assertEquals(unitsRepository.findById(id), Optional.empty(), "Строка " + id + " удалена");
            return;
        }
        assertEquals(unitsRepository.findById(id), Optional.empty(), "Строка не найдена");
    }
}