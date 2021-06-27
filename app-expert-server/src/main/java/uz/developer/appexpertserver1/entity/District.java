package uz.developer.appexpertserver1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.developer.appexpertserver1.entity.template.AbsNameEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class District extends AbsNameEntity {

    @ManyToOne(optional = false)
    private Region region;
}
