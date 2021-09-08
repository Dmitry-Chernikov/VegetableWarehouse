package ru.dmitry.VegetableWarehouse.converter;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dmitry.VegetableWarehouse.dto.GoodsDto;
import ru.dmitry.VegetableWarehouse.model.Goods;
import ru.dmitry.VegetableWarehouse.repo.GoodsRepository;
import ru.dmitry.VegetableWarehouse.repo.UnitsRepository;

import javax.annotation.PostConstruct;
import java.util.Objects;
@Component
public class GoodsMapper extends AbstractMapper<Goods, GoodsDto> {

    private final ModelMapper mapper;
    private final UnitsRepository unitsRepository;

    @Autowired
    public GoodsMapper(ModelMapper mapper, UnitsRepository unitsRepository) {
        super(Goods.class, GoodsDto.class);
        this.mapper = mapper;
        this.unitsRepository = unitsRepository;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(Goods.class, GoodsDto.class)
                .addMappings(m -> m.skip(GoodsDto::setUnitsId)).setPostConverter(toDtoConverter());
        mapper.createTypeMap(GoodsDto.class, Goods.class)
                .addMappings(m -> m.skip(Goods::setUnits)).setPostConverter(toEntityConverter());
    }



    public Converter<GoodsDto, Goods> toEntityConverter() {
        return context -> {
            GoodsDto source = context.getSource();
            Goods destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public Converter<Goods, GoodsDto> toDtoConverter() {
        return context -> {
            Goods source = context.getSource();
            GoodsDto destination = context.getDestination();
            mapSpecificFields(source, destination);
            return context.getDestination();
        };
    }

    public void mapSpecificFields(Goods source, GoodsDto destination) {
        destination.setUnitsId(Objects.isNull(source) || Objects.isNull(source.getId()) ? null : source.getUnits().getId());
    }

    void mapSpecificFields(GoodsDto source, Goods destination) {
        destination.setUnits(unitsRepository.findById(source.getUnitsId()).orElse(null));
    }
}
