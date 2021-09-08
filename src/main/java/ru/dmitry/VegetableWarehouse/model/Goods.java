package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "products_id")
        private Products products;

        /**
         * Наименование сорта
         */
        @Column(name = "name_variety", length = 50)
        private String varietyName;

        /**
         * Годен до
         */
        @DateTimeFormat(pattern="yyyy-MM-dd")
        @Column(name = "shelf_life")
        @Temporal(TemporalType.DATE)
        private Date shelfLife;

        /**
         * Ед.изм
         */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "units_id")
        private Units units;

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

        @OneToMany(mappedBy = "goods", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<BaseProducts> baseProductses;

}
