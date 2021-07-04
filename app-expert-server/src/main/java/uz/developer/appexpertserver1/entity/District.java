package uz.developer.appexpertserver1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.developer.appexpertserver1.entity.template.AbsNameEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class District extends AbsNameEntity {

    @JsonBackReference
    @ManyToOne(optional = false)
    private Region region;
}
