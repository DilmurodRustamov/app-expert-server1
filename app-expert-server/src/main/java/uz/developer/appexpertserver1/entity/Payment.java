package uz.developer.appexpertserver1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.developer.appexpertserver1.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Payment extends AbsEntity {

    @ManyToOne
    private PayType payType;

    @ManyToOne
    private Project project;

    private double amount;


    private Timestamp payDate;
}
