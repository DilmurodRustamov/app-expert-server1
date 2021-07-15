package uz.developer.appexpertserver1.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import uz.developer.appexpertserver1.entity.enums.RoleName;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private RoleName roleName;

    @Override
    public String getAuthority() {
        return roleName.name();
    }

    @ManyToMany
    private Set<User> users;
}
