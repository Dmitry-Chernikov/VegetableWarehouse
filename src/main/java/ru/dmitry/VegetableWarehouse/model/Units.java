package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;

/**
 * Единица измерния товара
 */
@Entity
@Table(name = "UNITS")
@Builder
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Units extends BaseEntity  {
    private static final long serialVersionUID = 3342749204729491943L;

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
}
