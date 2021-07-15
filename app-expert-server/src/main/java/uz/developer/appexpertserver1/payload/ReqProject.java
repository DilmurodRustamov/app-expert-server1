package uz.developer.appexpertserver1.payload;

import lombok.Data;
import uz.developer.appexpertserver1.entity.Attachment;
import uz.developer.appexpertserver1.entity.ProjectChat;
import uz.developer.appexpertserver1.entity.enums.ExpertizeType;
import uz.developer.appexpertserver1.entity.enums.PersonType;
import uz.developer.appexpertserver1.entity.enums.ProjectStatus;
import uz.developer.appexpertserver1.entity.enums.ProjectType;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

@Data
public class ReqProject {

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    private UUID userId;

    private String name;

    private String projector;

    private String projectorTin;

    private String projectorPhoneNumber;

    private boolean seenAdmin;
    private boolean seenExpert;
    private boolean seenClient = true;

    private double price;

    private ProjectType projectType;

    private ExpertizeType expertizeType;

    private Integer appNumber;

    private ProjectStatus projectStatus;

    private List<UUID> projectChats;

    private List<UUID> permissionOrganization;

    private List<UUID> engineeringAndSearching;

    private List<UUID> art;

    private List<UUID> confirmed;

    private List<UUID> working;

    private List<UUID> defectAct;

    private List<UUID> taskProject;
}
