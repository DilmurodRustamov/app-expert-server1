package uz.developer.appexpertserver1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import uz.developer.appexpertserver1.entity.District;
import uz.developer.appexpertserver1.entity.Project;

import java.util.UUID;


public interface ProjectRepository extends JpaRepository<Project, UUID> {
}
