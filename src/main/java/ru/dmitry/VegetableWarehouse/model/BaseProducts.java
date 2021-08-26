package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.UUID;

/**
 * База всех продуктов
 */
@Entity
//@Table(name = "PRODUCTS BASE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseProducts extends BaseEntity{
        private static final long serialVersionUID = -4265266289869875308L;

        /**
         * Уникальный идентификатор товара в базе штрих код

                @Column(name = "barcode")
                private UUID barcode;
         */


        /**
         * Имя типа склада где храниться товар
         */
        @Column(name = "type_warehouse_fk")
        private long warehouseName;

        /**
         * Имя товара
         */
        @Column(name = "goods_fk")
        private long goodsName;
}
