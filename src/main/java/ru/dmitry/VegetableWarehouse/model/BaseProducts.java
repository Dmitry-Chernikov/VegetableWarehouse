package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.UUID;

/**
 * База всех продуктов
 */
@Entity
@Table(name = "PRODUCTS BASE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class BaseProducts extends BaseEntity{
        private static final long serialVersionUID = -4265266289869875308L;

        /**
         * Уникальный идентификатор товара в базе штрих код
         */
        @Column(name = "Barcode")
        private UUID barcode;

        /**
         * Имя типа склада где храниться товар
         */
        @Column(name = "Warehouse_FK")
        private int warehouseName;

        /**
         * Имя товара
         */
        @Column(name = "Name_Goods_FK")
        private int goodsName;
}
