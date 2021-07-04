package uz.developer.appexpertserver1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.developer.appexpertserver1.entity.enums.ExpertizeType;
import uz.developer.appexpertserver1.entity.enums.PersonType;
import uz.developer.appexpertserver1.entity.enums.ProjectStatus;
import uz.developer.appexpertserver1.entity.enums.ProjectType;
import uz.developer.appexpertserver1.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
//Ariza beriladi
public class Project extends AbsEntity {

    @Enumerated(EnumType.STRING)
    private PersonType personType;

//    @ManyToOne
//    private User user;

    private String name;

    private String projector;

    private String projectorTin;

    private String projectorPhoneNumber;

    private boolean seenAdmin;
    private boolean seenExpert;
    private boolean seenClient = true;

//    @ManyToOne
//    private User expert;

    private double price;

    @Enumerated(EnumType.STRING)
    private ProjectType projectType;

    @Enumerated(EnumType.STRING)
    private ExpertizeType expertizeType;

    @Column(updatable = false)
    private Integer appNumber;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @OneToMany(mappedBy = "project")
    private List<ProjectChat> projectChats;






    @OneToMany
    private List<Attachment> permissionOrganization;        //ruxsat etuvchi tashkilotning ruhsat va hulosalarin

    @OneToMany
    private List<Attachment> engineeringAndSearching;       //Muhandislik izlanishlari(geologiya va topoxarita)

    @OneToMany
    private List<Attachment> art;                           //Art va loyiha topshirigi

    @OneToMany
    private List<Attachment> confirmed;                     //tasdiqlangan eskiz loyiha

    @OneToMany
    private List<Attachment> working;                       //ishchi loyiha 2

    @OneToMany
    private List<Attachment> defectAct;                     //nuqsonlar dalolatnomalari 2

    @OneToMany
    private List<Attachment> taskProject;                   //loyihalash topshirig'i 2
}
