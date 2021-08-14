package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;
import java.util.Date;

/**
 * Сотрудники склада
 */
@Entity
@Table(name = "EMPLOYEE")
//@Builder
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseEntity {
    private static final long serialVersionUID = 8281530488380256469L;

    /**
     * ФИО сотрудника
     */
    @Column(name = "Full_Name")
    private String fullName;

    /**
     * Дата рождения сотрудника
     */
    @Column(name = "Date_Birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateBirth;

    /**
     * Должность сотрудника
     */
    @Column(name = "Position")
    private String position;

    /**
     * Адрес проживания
     */
    @Column(name = "Address_accommodation")
    private String accommodationAddress;
    /**
     * Телефон домашний
     */
    @Column(name = "Telephone_Home")
    private String telephoneHome;

    /**
     * Телефон мобильный
     */
    @Column(name = "Telephone_mobil")
    private String telephoneMobil;
}
