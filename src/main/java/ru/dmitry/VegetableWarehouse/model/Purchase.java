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
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "base_products_id")
        private BaseProducts baseProducts;

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
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "suppliers_id")
        private Suppliers suppliers;

        /**
         * ФИО прнинявшего товар
         */
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "employee_id")
        private Employee employee;

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
