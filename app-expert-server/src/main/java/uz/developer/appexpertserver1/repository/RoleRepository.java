package uz.developer.appexpertserver1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developer.appexpertserver1.entity.Role;
import uz.developer.appexpertserver1.entity.User;
import uz.developer.appexpertserver1.entity.enums.RoleName;

import java.util.UUID;


public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRoleName(RoleName roleName);
}
