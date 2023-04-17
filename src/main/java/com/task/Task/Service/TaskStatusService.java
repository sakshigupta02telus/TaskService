package com.task.Task.Service;
import com.task.Task.Entity.TaskStatus;
import com.task.Task.Repo.TaskStatusRepo;
import com.task.Task.TaskStatusDto.TaskStatusRequest;
import com.task.Task.TaskStatusDto.TaskStatusResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class TaskStatusService {

    @Autowired
    TaskStatusRepo taskStatusRepo;

    public TaskStatusResponse getTaskStatusResponse(TaskStatus taskStatus){
        TaskStatusResponse taskStatusResponse=new TaskStatusResponse();
        taskStatusResponse.setTaskStatus(taskStatus.getTaskstatus());
        taskStatusResponse.setId(taskStatus.getId());
        return taskStatusResponse;
    }

    public TaskStatus createTaskStatus(TaskStatusRequest taskStatusRequest){
        TaskStatus taskStatus=new TaskStatus();
        taskStatus.setTaskstatus(taskStatusRequest.getTaskStatus());
        taskStatusRepo.save(taskStatus);
        return taskStatus;
    }

    public TaskStatus getTaskStatus(Long id){
        return taskStatusRepo.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<TaskStatusResponse>getAllTaskStatus(){
        Iterable<TaskStatus> taskStatuses= taskStatusRepo.findAll();
        List<TaskStatusResponse> taskStatusResponses=new ArrayList<>();
        for(TaskStatus taskStatus: taskStatuses){
            taskStatusResponses.add(getTaskStatusResponse(taskStatus));
        }
        return taskStatusResponses;
    }
}
