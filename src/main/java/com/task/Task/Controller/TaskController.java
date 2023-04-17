package com.task.Task.Controller;
import com.task.Task.Entity.Task;
import com.task.Task.Service.TaskService;
import com.task.Task.TaskDto.TaskRequest;
import com.task.Task.TaskDto.TaskResponse;
import com.task.common.services.InternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    InternalApiService internalApiService;


    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest taskRequest){
        Task task = taskService.createTask(taskRequest);
        return taskService.getTaskResponse(task);
    }

    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable Long id){
        System.out.println("----------------------------------------------------");
        Task task= taskService.getTask(id);
        return taskService.getTaskResponse(task);

    }

    @GetMapping
    public List<TaskResponse> getAllTask(){
        List<TaskResponse>  taskResponses= taskService.getAllTask();
        return taskResponses;
    }


}
