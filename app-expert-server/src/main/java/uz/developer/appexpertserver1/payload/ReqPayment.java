package uz.developer.appexpertserver1.payload;

import lombok.Data;
import uz.developer.appexpertserver1.entity.PayType;
import uz.developer.appexpertserver1.entity.Project;

import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.UUID;

@Data
public class ReqPayment {
    private Integer payTypeId;
    private UUID projectId;
    private double amount;
}
