package com.task.Task.Controller;
import com.task.Task.Entity.TaskStatus;
import com.task.Task.Service.TaskStatusService;
import com.task.Task.TaskStatusDto.TaskStatusRequest;
import com.task.Task.TaskStatusDto.TaskStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/taskstatus")
public class TaskStatusController {

    @Autowired
    TaskStatusService taskStatusService;

    @PostMapping
    public TaskStatusResponse createTaskStatus(@Valid @RequestBody TaskStatusRequest taskStatusRequest){
        TaskStatus taskStatus=taskStatusService.createTaskStatus(taskStatusRequest);
        return taskStatusService.getTaskStatusResponse(taskStatus);
    }


    @GetMapping("/{id}")
    public TaskStatusResponse getTaskStatus(@PathVariable Long id){
        TaskStatus taskStatus= taskStatusService.getTaskStatus(id);
        return taskStatusService.getTaskStatusResponse(taskStatus);
    }


    @GetMapping
    public List<TaskStatusResponse> getAllTaskStatus(){

        List<TaskStatusResponse>taskStatusResponses=taskStatusService.getAllTaskStatus();
        return taskStatusResponses;
    }

}
