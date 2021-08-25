package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * Расходная накладная
 */
@Entity
@Table(name = "SALES")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Sales extends BaseEntity{
            private static final long serialVersionUID = -4958131087059395614L;


    /**
     * Уникальный идентификатор расходной товарной наклодной
     * @Column(name = "Purchase_ID_TT")
     * private UUID barcode;
     */

    /**
     * Имя товара
     */
    @Column(name = "Name_ProductsBase_FK")
    private int productsBase;

    /**
     * Количество товара
     */
    @Column(name = "Count_Product")
    private double countProduct;

    /**
     * Наименование получателя
     */
    @Column(name = "Name_Client")
    private String clientName;

    /**
     * ФИО прнинявшего клиента товар
     */
    @Column(name = "Full_Name_Client_FK")
    private int clientFullName;

    /**
     * ФИО сдавшего товар
     */
    @Column(name = "Full_Name_Employee_FK")
    private int employeeSalesFullName;

    /**
     * Дата расхода товара на склад
     */
    @Column(name = "Date_Operation")
    private Date operationDate;

    /**
     * Цена товара
     */
    @Column(name = "Price_Value")
    private double valuePrice;

}
