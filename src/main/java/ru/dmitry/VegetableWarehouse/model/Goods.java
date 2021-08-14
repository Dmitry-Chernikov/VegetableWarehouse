package ru.dmitry.VegetableWarehouse.model;

        import lombok.*;
        import javax.persistence.*;
        import java.util.Date;

/**
 * Товары
 */
@Entity
@Table(name = "GOODS")
@Builder
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Goods extends BaseEntity{
    private static final long serialVersionUID = -935293741889753637L;

    /**
     * Наименование продукта
     */
    @Column(name = "Production")
    @Enumerated(EnumType.STRING)
    private Production productionName;

    /**
     * Наименование сорта
     */
    @Column(name = "Name_Variety")
    private String varietyName;

    /**
     * Срок годности
     */
    @Column(name = "Shelf_life")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lifeShelf;

    /**
     * Ед.изм
     */
    @Column(name = "Unit")
    @Enumerated(EnumType.STRING)
    private String unit;

    /**
     * Наименование производителя
     */
    @Column(name = "Name_Manufacture")
    private String manufactureName;

    /**
     * Страна происхождения
     */
    @Column(name = "Couty_manufacture")
    private String manufactureCouty;
}
