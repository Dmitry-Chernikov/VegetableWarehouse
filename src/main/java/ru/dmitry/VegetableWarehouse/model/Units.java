package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;

/**
 * Еденицы измерения
 */

@Table(name = "UNITS")
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Units extends BaseEntity {

    private static final long serialVersionUID = 2348563159789054502L;
    /**
     * Измеряемая велечина
     */
    @Column(name = "Measurement unit", nullable = false, unique = true)
    private String measurementUnit;
    /**
     * Обозначение еденицы измерения
     */
    @Column(name = "Designation unit", nullable = false, unique = true)
    private String designationUnit;

}