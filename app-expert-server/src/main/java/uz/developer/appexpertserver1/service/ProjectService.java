package uz.developer.appexpertserver1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.developer.appexpertserver1.entity.Project;
import uz.developer.appexpertserver1.entity.enums.ProjectType;
import uz.developer.appexpertserver1.payload.ApiResponse;
import uz.developer.appexpertserver1.payload.ReqProject;
import uz.developer.appexpertserver1.repository.ProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    AttachmentRe


    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public ApiResponse addProject(ReqProject reqProject){
        Project project = new Project();
        if (reqProject.getProjectType().equals(ProjectType.RECONSTRUCTION)){
            project.setPermissionOrganization();
        }

        project.setName(reqProject.getName());
        projectRepository.save(project);
        return new ApiResponse(true," Added ");
    }
}
