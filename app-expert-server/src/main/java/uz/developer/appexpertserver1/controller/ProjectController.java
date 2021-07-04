package uz.developer.appexpertserver1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.developer.appexpertserver1.entity.Project;
import uz.developer.appexpertserver1.payload.ApiResponse;
import uz.developer.appexpertserver1.payload.ReqProject;
import uz.developer.appexpertserver1.repository.ProjectRepository;
import uz.developer.appexpertserver1.service.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {


    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/get")
    public List<Project> getAll(){
        return projectRepository.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProject(@RequestBody ReqProject reqProject){
        ApiResponse response = projectService.addProject(reqProject);
        return ResponseEntity.status(response.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(response);
    }
}
