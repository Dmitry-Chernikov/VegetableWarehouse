package ru.dmitry.VegetableWarehouse.model;

//import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass //аннотация используется, чтобы указать, что текущие атрибуты аннотированного типа наследуются любой Entity сущностью класса-наследника
@NoArgsConstructor //создаёт конструктор по умолчанию, генерирует конструктор без параметров.
@EqualsAndHashCode // lombok сгенерирует методы equals(Object other) и hashCode()
@AllArgsConstructor //генерирует конструктор с одним параметром для каждого поля в классе
@Getter
@Setter
public abstract class BaseEntity implements Serializable {
        private static final long serialVersionUID = 1972709113480192104L;

        @Id
        @JsonIgnore
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        //@Column(name="id")
        private long id;

}
