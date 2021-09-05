package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Сотрудники склада
 */
@Entity
//@Table(name = "EMPLOYEE")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Employee extends BaseEntity {
        private static final long serialVersionUID = 8281530488380256469L;

        /**
         * ФИО сотрудника
         */
        @Column(name = "full_name", length = 50)
        private String fullName;

        /**
         * Дата рождения сотрудника
         */
        @DateTimeFormat(pattern="yyyy-MM-dd")
        @Column(name = "date_birth")
        @Temporal(TemporalType.DATE)
        private Date dateBirth;

        /**
         * Должность сотрудника
         */
        @Column(name = "working_position", length = 50)
        private String position;

        /**
         * Адрес проживания
         */
        @Column(name = "address_accommodation", length = 100)
        private String accommodationAddress;
        /**
         * Телефон домашний
         */
        @Column(name = "telephone_home", length = 20)
        private String telephoneHome;

        /**
         * Телефон мобильный
         */
        @Column(name = "telephone_mobil", length = 20)
        private String telephoneMobil;

        @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
        private List<Sales> saleses;

        @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY)
        private List<Purchase> purchases;

}
