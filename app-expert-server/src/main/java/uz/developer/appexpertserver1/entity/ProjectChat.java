package uz.developer.appexpertserver1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.developer.appexpertserver1.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProjectChat extends AbsEntity {

    @ManyToOne
    private Project project;

    private String request;

    @OneToOne
    private Attachment byExpert;
    private boolean responded;              //umumiy javob(javob berildi berilmadi)
    private String response;

    @OneToOne
    private Attachment byClient;
}
