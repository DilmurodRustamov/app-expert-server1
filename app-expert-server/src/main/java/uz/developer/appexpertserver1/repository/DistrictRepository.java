package uz.developer.appexpertserver1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.developer.appexpertserver1.entity.District;
import uz.developer.appexpertserver1.entity.Region;

import java.util.UUID;

@RepositoryRestResource(path = "district")
public interface DistrictRepository extends JpaRepository<District, UUID> {
}
