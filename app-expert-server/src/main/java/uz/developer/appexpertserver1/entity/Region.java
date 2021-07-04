package uz.developer.appexpertserver1.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.developer.appexpertserver1.entity.template.AbsEntity;
import uz.developer.appexpertserver1.entity.template.AbsNameEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Region extends AbsNameEntity {

    @JsonManagedReference
    @OneToMany(mappedBy = "region", fetch= FetchType.EAGER)
    private List<District> districts;
}
