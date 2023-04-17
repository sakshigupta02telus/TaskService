package com.task.Project.Services;
import com.task.Project.Repo.ProjectRepository;
import com.task.Project.dto.ProjectRequest;
import com.task.Project.dto.ProjectResponse;
import com.task.Project.entity.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project createProject(ProjectRequest projectRequest){

        Project project= new Project();
        project.setProjectName(projectRequest.getProjectName());
        project.setIsActive(projectRequest.getIsActive());
        projectRepository.save(project);
        return project;
    }


    public Project getProject(Long id){

        return projectRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public ProjectResponse getProjectResponse(Project project){
        ProjectResponse projectResponse=new ProjectResponse();
        projectResponse.setProjectName(project.getProjectName());
        projectResponse.setIsActive(project.getIsActive());
        projectResponse.setId(project.getId());
        return projectResponse;

    }

    public List<ProjectResponse> getAllProjects() {

        Iterable<Project> projects =projectRepository.findAll();
        List<ProjectResponse> projectResponses= new ArrayList<>();
        for(Project project : projects){

            projectResponses.add(getProjectResponse(project));
        }
        return projectResponses;
    }

    }





