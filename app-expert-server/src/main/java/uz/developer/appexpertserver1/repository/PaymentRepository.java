package uz.developer.appexpertserver1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import uz.developer.appexpertserver1.entity.Payment;

import java.util.UUID;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
