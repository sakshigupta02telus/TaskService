package com.task.Project.Controller;
import com.task.Project.Services.ProjectService;
import com.task.Project.dto.ProjectRequest;
import com.task.Project.dto.ProjectResponse;
import com.task.Project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;


    @PostMapping
    public ProjectResponse createProject(@Valid @RequestBody  ProjectRequest projectRequest){

        Project project = projectService.createProject(projectRequest);
         return projectService.getProjectResponse(project);
    }
    @GetMapping("/{id}")
    public ProjectResponse getProject(@PathVariable Long id){

        Project project = projectService.getProject(id);
        return projectService.getProjectResponse(project);

    }


    @GetMapping
    public List<ProjectResponse> getAllProjects(){
        List<ProjectResponse> projectResponses = projectService.getAllProjects();
        return projectResponses;
    }



}
