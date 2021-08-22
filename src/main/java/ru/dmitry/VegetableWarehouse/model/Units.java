package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Единица измерния товара
 */
@Entity
@Table(name = "UNITS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Units extends BaseEntity  {
    private static final long serialVersionUID = 8349081394822016285L;

    /**
     * Название еденицы
     */
    @Column(name = "Unit measurement")
    private String unitMeasurement;

    /**
     * Обозначение еденицы
     */
    @Column(name = "Designation unit")
    private String unitDesignation;

    @OneToMany(mappedBy = "unitName")
    private List<Goods> goodsList;

}
