package ru.dmitry.VegetableWarehouse.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Единицы измерения
 */
@Entity
@Getter
@Setter
public class Units extends BaseEntity {

        private static final long serialVersionUID = 2348563159789054502L;

        /**
         * Измеряемая величина
         */
        @Column(name = "unit_measurement", length = 50)
        private String measurementUnit;

        /**
         * Обозначение единицы измерения
         */
        @Column(name = "designation_unit", length = 10)
        private String designationUnit;

        @OneToMany(mappedBy = "units", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Goods> goodses;


}