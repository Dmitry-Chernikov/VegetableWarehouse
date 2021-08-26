package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Приходная накладная
 */
@Entity
//@Table(name = "PURCHASE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Purchase extends BaseEntity{
        private static final long serialVersionUID = -2881785172249442237L;

        /**
        * Уникальный идентификатор приходной товарной наклодной
         */
                @Column(name = "barcode")
                private UUID barcode;


        /**
         * Имя товара
         */
        @Column(name = "base_products_fk")
        private long nameGoodsPurchase;

        /**
         * Количество товара
         */
        @Column(name = "count_product")
        private double countProduct;

        /**
         * Наименование поставщика
         */
        @Column(name = "name_suppliers", length = 50)
        private String suppliersName;

        /**
         * ФИО сдавшего товар
         */
        @Column(name = "suppliers_fk")
        private long suppliersFullName;

        /**
         * ФИО прнинявшего товар
         */
        @Column(name = "employee_fk")
        private long employeePurchaseFullName;

        /**
         * Дата прихода товара на склад
         */
        @Column(name = "date_operation")
        private Date operationDate;

        /**
         * Цена товара
         */
        @Column(name = "price_value")
        private double valuePrice;
}
