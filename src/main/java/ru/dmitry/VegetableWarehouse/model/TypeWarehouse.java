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
 * Список типов складов
 */
@Entity
@Getter
@Setter
public class TypeWarehouse extends BaseEntity{   
        private static final long serialVersionUID = 1353555820728941054L;
        
        /**
         * Наименование склада
         */
        @Column(name = "name_warehouse", length = 50)
        private String nameWarehouse;

        @OneToMany(mappedBy = "typeWarehouse", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<BaseProducts> baseProductses;

/**
         * Хранилище силосного типа
         * Silage,
         */

        /**
         * Хранилище ангарного типа
         * Hangar,
         */

        /**
         * Хранилище подвального типа
         *Cellar
         */
}
