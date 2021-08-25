package ru.dmitry.VegetableWarehouse.model;

import lombok.*;
import javax.persistence.*;

/**
 * Клиенты
 */

@Entity
@Table(name = "CLIENTS")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Clients extends BaseEntity{
        private static final long serialVersionUID = -1007091243262555550L;

        /**
         * Наименование получателя
         */
        @Column(name = "Clint_Name")
        private String name;

        /**
         * Код учётного номера плательщика УНП
         */
        @Column(name = "Code_UNP")
        private String codeUNP;

        /**
         * Юридический адрес
         */
        @Column(name = "Legal_address")
        private String legalAddress;

        /**
         * Телефон
         */
        @Column(name = "Telephone_Number")
        private String telephoneNumber;

        /**
         * Контактное лицо
         */
        @Column(name = "Full_Name")
        private String fullName;

        /**
         * Должность
         */
        @Column(name = "Working_Position")
        private String workingPosition;

}
