package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Еденицы измерения
 */

@Entity
//@Table(name = "UNITS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Units extends BaseEntity {

        private static final long serialVersionUID = 2348563159789054502L;

        /**
         * Измеряемая велечина
         */
        @Column(name = "unit_measurement", length = 50)
        private String measurementUnit;

        /**
         * Обозначение еденицы измерения
         */
        @Column(name = "designation_unit", length = 10)
        private String designationUnit;

        @OneToMany(mappedBy = "units")
        private Set<Goods> goodses;

}