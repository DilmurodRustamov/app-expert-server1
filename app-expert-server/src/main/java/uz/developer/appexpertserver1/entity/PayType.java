package uz.developer.appexpertserver1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.developer.appexpertserver1.entity.template.AbsNameEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class PayType extends AbsNameEntity {
    private String color;
}
