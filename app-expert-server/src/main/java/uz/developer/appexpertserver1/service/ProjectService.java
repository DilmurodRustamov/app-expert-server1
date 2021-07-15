package uz.developer.appexpertserver1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.developer.appexpertserver1.entity.Project;
import uz.developer.appexpertserver1.entity.enums.ProjectType;
import uz.developer.appexpertserver1.payload.ApiResponse;
import uz.developer.appexpertserver1.payload.ReqProject;
import uz.developer.appexpertserver1.repository.AttachmentRepository;
import uz.developer.appexpertserver1.repository.ProjectRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectService {

    @Autowired
    private final ProjectRepository projectRepository;

    @Autowired
    AttachmentRepository attachmentRepository;


    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }


    public ApiResponse addProject(ReqProject reqProject) {
        Project project = new Project();
        if (reqProject.getProjectType().equals(ProjectType.RECONSTRUCTION)) {
            project.setPermissionOrganization(attachmentRepository.findAllByIdIn(reqProject.getPermissionOrganization()).orElseThrow(() -> new ResourceNotFoundException("Ruxsatlar boycha fayllar topilmadi")));
            project.setEngineeringAndSearching(attachmentRepository.findAllByIdIn(reqProject.getEngineeringAndSearching()).orElseThrow(() -> new ResourceNotFoundException("Muhandislik izlanishlar boycha fayllar topilmadi")));
            project.setArt(attachmentRepository.findAllByIdIn(reqProject.getArt()).orElseThrow(() -> new ResourceNotFoundException("Art va loyiha topshirig'i bo'ycha fayl topilmadi")));
            project.setConfirmed(attachmentRepository.findAllByIdIn(reqProject.getConfirmed()).orElseThrow(() -> new ResourceNotFoundException("Tasdiqlangan eskiz loyiha topilmadi")));
            project.setWorking(attachmentRepository.findAllByIdIn(reqProject.getWorking()).orElseThrow(() -> new ResourceNotFoundException("Ishchi loyiha boycha fayllar topilmadi")));
        }
        if (reqProject.getProjectType().equals(ProjectType.CURRENT_REPAIRING)) {
            project.setWorking(attachmentRepository.findAllByIdIn(reqProject.getWorking()).orElseThrow(() -> new ResourceNotFoundException("loyiha ishi bo'yicha fayl topilmadi")));
            project.setDefectAct(attachmentRepository.findAllByIdIn(reqProject.getDefectAct()).orElseThrow(() -> new ResourceNotFoundException(" nuqson dalolatnomalari boyicha fayl topilmadi")));
            project.setTaskProject(attachmentRepository.findAllByIdIn(reqProject.getTaskProject()).orElseThrow(() -> new ResourceNotFoundException("")));
        }
        project.setAppNumber(reqProject.getAppNumber());
        project.setPersonType(reqProject.getPersonType());
        project.setProjectStatus(reqProject.getProjectStatus());
        project.setProjectType(reqProject.getProjectType());
        project.setExpertizeType(reqProject.getExpertizeType());
        project.setName(reqProject.getName());
        project.setProjector(reqProject.getProjector());
        project.setProjectorTin(reqProject.getProjectorTin());
        project.setProjectorPhoneNumber(reqProject.getProjectorPhoneNumber());
        project.setPrice(reqProject.getPrice());
        projectRepository.save(project);
        return new ApiResponse(true, "Added!");
    }

    public List<Project> getAllProject() {
        return projectRepository.findAll();
    }

    public Project getProject(UUID id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found!"));
    }
    //2-usul
//    public Project getProject(UUID id) {
//        Optional<Project> optionalProject = projectRepository.findById(id);
//        return optionalProject.orElseGet(Project::new);
//    }

    public ApiResponse deleteProject(UUID id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return new ApiResponse(true, " Project deletes! ");
        }
        return new ApiResponse(false, "Project not found!");
    }

    //TODO buni to'ldirishim kk
    public ApiResponse editProject(UUID id, ReqProject reqProject) {
        Project project = new Project();
        if (projectRepository.existsById(id)) {
            project.setProjectType(reqProject.getProjectType());
            projectRepository.save(project);
            return new ApiResponse(true, "edit project");
        }
        return new ApiResponse(false, "project not found!");

    }
}
