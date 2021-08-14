package ru.dmitry.VegetableWarehouse.model;
import lombok.*;
import javax.persistence.*;
import java.util.UUID;

/**
 * База всех продуктов
 */
@Entity
@Table(name = "BASE")
//@Builder
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductsBase extends BaseEntity{
    private static final long serialVersionUID = -4265266289869875308L;

    /**
     * Уникальный идентификатор товара в базе штрих код
     */
    @Column(name = "Barcode")
    private UUID barcode;

    /**
     * Имя типа склада где храниться товар
     */
    @Column(name = "Warehouse")
    @Enumerated(EnumType.STRING)
    private TypeWarehouse warehouseName;

    /**
     * Имя товара
     */
    @ManyToOne
    //@OneToMany
    //@OneToOne
    @JoinColumn(name = "Name_Goods_FK")
    private Goods goodsName;
}
