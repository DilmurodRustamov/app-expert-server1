package uz.developer.appexpertserver1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.developer.appexpertserver1.entity.PayType;
import uz.developer.appexpertserver1.entity.Region;

import java.util.UUID;

@RepositoryRestResource(path = "payType")
public interface PayTypeRepository extends JpaRepository<PayType, Integer> {
}
