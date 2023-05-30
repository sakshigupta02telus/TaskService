package com.task.Task.Service;
import com.task.Project.Repo.ProjectRepository;
import com.task.Project.entity.Project;
import com.task.Task.Entity.Task;
import com.task.Task.Entity.TaskCategory;
import com.task.Task.Entity.TaskStatus;
import com.task.Task.Repo.TaskCategoryRepo;
import com.task.Task.Repo.TaskRepository;
import com.task.Task.Repo.TaskStatusRepo;
import com.task.Task.TaskDto.TaskRequest;
import com.task.Task.TaskDto.TaskResponse;
import com.task.Task.TaskDto.UserResponse;
import com.task.common.services.InternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskStatusRepo taskStatusRepo;

    @Autowired
    TaskCategoryRepo taskCategoryRepo;

    @Autowired
    InternalApiService internalApiService;


    public TaskResponse getTaskResponse(Task task){
        UserResponse createdBy =internalApiService.getUser(task.getCreatedById());
        UserResponse assignedTo=internalApiService.getUser(task.getAssignedToId());
        TaskResponse taskResponse=new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setCategory(task.getCategory());
        taskResponse.setTitle(task.getTitle());
        taskResponse.setCreatedBy(createdBy);
        taskResponse.setDueDate(task.getDueDate());
        taskResponse.setStatus(task.getStatus());
        taskResponse.setAssignedTo(assignedTo);
        taskResponse.setProject(task.getProject());
        taskResponse.setCreatedOn(task.getCreatedOn());
        return taskResponse;
    }

    public Task createTask(TaskRequest taskRequest){


        Project project =projectRepository.findById(taskRequest.getProjectId()).orElseThrow(RuntimeException::new);
        TaskCategory taskCategory=taskCategoryRepo.findById(taskRequest.getTaskCategoryId()).orElseThrow(RuntimeException::new);
        TaskStatus taskStatus=taskStatusRepo.findById(taskRequest.getStatusId()).orElseThrow(RuntimeException::new);
        internalApiService.getUser(taskRequest.getCreatedById());
        internalApiService.getUser(taskRequest.getAssignedToId());
        //custom exception-400status code
        Task task = new Task();
        task.setCreatedById(taskRequest.getCreatedById());
        task.setDescription(taskRequest.getDescription());
        task.setAssignedToId(taskRequest.getAssignedToId());
        task.setTitle(taskRequest.getTitle());
        task.setCategory(taskCategory);
        task.setDueDate(taskRequest.getDueDate());
        task.setProject(project);
        task.setStatus(taskStatus);
        taskRepository.save(task);
        return task;
    }
    public List<TaskResponse> getAllTask(){
        Iterable<Task> task= taskRepository.findAll();
        List<TaskResponse> taskResponses=new ArrayList<>();
        for(Task tasks : task){

            taskResponses.add(getTaskResponse(tasks));
        }
        return taskResponses;
    }

    public Task getTask(Long id){
        return taskRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public Task updateTask(TaskRequest taskRequest, Long id){
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(!optionalTask.isPresent()){
            throw new RuntimeException("\"task Belongs to this ID : \" + id + \"is not Available !!\"") ;
        }
        else{
            Task task= optionalTask.get();
            Project project =projectRepository.findById(taskRequest.getProjectId()).orElseThrow(RuntimeException::new);
            TaskCategory taskCategory=taskCategoryRepo.findById(taskRequest.getTaskCategoryId()).orElseThrow(RuntimeException::new);
            TaskStatus taskStatus=taskStatusRepo.findById(taskRequest.getStatusId()).orElseThrow(RuntimeException::new);
            internalApiService.getUser(taskRequest.getCreatedById());
            internalApiService.getUser(taskRequest.getAssignedToId());
            task.setCreatedById(taskRequest.getCreatedById());
            task.setDescription(taskRequest.getDescription());
            task.setAssignedToId(taskRequest.getAssignedToId());
            task.setTitle(taskRequest.getTitle());
            task.setCategory(taskCategory);
            task.setDueDate(taskRequest.getDueDate());
            task.setProject(project);
            task.setStatus(taskStatus);
            taskRepository.save(task);
            return task;
        }
    }

}
