package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Еденицы измерения
 */
@Entity
@Getter
@Setter
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

        @OneToMany(mappedBy = "units", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Goods> goodses;


}