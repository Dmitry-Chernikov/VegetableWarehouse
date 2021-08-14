package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

/**
 * Приходная накладная
 */
@Entity
@Table(name = "PURCHASE")
//@Builder
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Purchase extends BaseEntity{
    private static final long serialVersionUID = -2881785172249442237L;

    /**
     * Уникальный идентификатор приходной товарной наклодной
     */
    @Column(name = "Purchase_ID_TT")
    private UUID barcode;

    /**
     * Имя товара
     */
    @ManyToOne
    //@OneToMany
    //@OneToOne
    //@ManyToMany
    @JoinColumn(name = "Name_Goods_FK")
    private ProductsBase nameGoods;

    /**
     * Количество товара
     */
    @Column(name = "Count_Product")
    private double countProduct;

    /**
     * Наименование поставщика
     */
    @Column(name = "Name_Suppliers")
    private String suppliersName;

    /**
     * ФИО прнинявшего товар
     */
    @ManyToOne
    //@OneToMany
    //@OneToOne
    //@ManyToMany
    @JoinColumn(name = "Full_Name_Suppliers_FK")
    private Suppliers suppliersFullName;

    /**
     * ФИО сдавшего товар
     */
    @ManyToOne
    //@OneToMany
    //@OneToOne
    //@ManyToMany
    @JoinColumn(name = "Full_Name_Employee_FK")
    private Employee employeeFullName;

    /**
     * Дата прихода товара на склад
     */
    @Column(name = "Date_Operation")
    private Date operationDate;

    /**
     * Цена товара
     */
    @Column(name = "Price_Value")
    private double valuePrice;
}
