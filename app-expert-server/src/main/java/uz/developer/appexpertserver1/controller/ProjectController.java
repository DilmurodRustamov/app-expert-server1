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
import java.util.UUID;

@RestController
@RequestMapping("/api/project")
public class ProjectController {


    @Autowired
    ProjectService projectService;

    @Autowired
    ProjectRepository projectRepository;



    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<ApiResponse> addProject(@RequestBody ReqProject reqProject){
        ApiResponse response = projectService.addProject(reqProject);
        return ResponseEntity.status(response.isSuccess()? HttpStatus.CREATED:HttpStatus.CONFLICT).body(response);
    }

    @GetMapping("/list")
    @ResponseBody
    public List<Project> getProjects(){
        return projectService.getAllProject();
    }

    @GetMapping("/get/{id}")
    @ResponseBody
    public Project getProject(@PathVariable UUID id){
        return projectService.getProject(id);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<ApiResponse> deleteProject(@PathVariable UUID id){
        ApiResponse response = projectService.deleteProject(id);
        return ResponseEntity.status(response.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(response);
    }

//    @DeleteMapping("/delete/{id}")
//    @ResponseBody
//    public boolean deleteProject(@PathVariable UUID id){
//        projectRepository.deleteById(id);
//        return true;
//    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<ApiResponse> editProject(@PathVariable UUID id,@RequestBody ReqProject reqProject){
        ApiResponse response = projectService.editProject(id, reqProject);
        return ResponseEntity.status(response.isSuccess()?HttpStatus.OK:HttpStatus.CONFLICT).body(response);
    }
}
