package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * Товары
 */
@Entity
//@Table(name = "GOODS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Goods extends BaseEntity{

        private static final long serialVersionUID = -935293741889753637L;

        /**
         * Наименование продукта
         */
        @Column(name = "products_fk")
        private long productionName;

        /**
         * Наименование сорта
         */
        @Column(name = "name_variety", length = 50)
        private String varietyName;

        /**
         * Годен до
         */
        @Column(name = "shelf_life")
        @Temporal(TemporalType.TIMESTAMP)
        private Date shelfLife;

        /**
         * Ед.изм
         */
        @Column(name = "units_fk")
        private long unitName;

        /**
         * Наименование производителя
         */
        @Column(name = "name_manufacture", length = 100)
        private String manufactureName;

        /**
         * Страна происхождения
         */
        @Column(name = "manufacture_country", length = 100)
        private String manufactureCountry;
}
