package uz.developer.appexpertserver1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.developer.appexpertserver1.entity.Region;
import uz.developer.appexpertserver1.entity.User;
import uz.developer.appexpertserver1.payload.ApiResponse;

import java.util.UUID;


public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmailEqualsIgnoreCase(String email);
    boolean existsByPhoneNumber(String phoneNumber);
    boolean existsByTin(String tin);

}
