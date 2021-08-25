package ru.dmitry.VegetableWarehouse.model;

//import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass //аннотация используется, чтобы указать, что текущие атрибуты аннотированного типа наследуются любой Entity сущностью класса-наследника
@NoArgsConstructor //создаёт конструктор по умолчанию
@Getter
@Setter
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1972709113480192104L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID")
    private long id;

}
