package com.task.Task.Service;
import com.task.Task.Entity.TaskCategory;
import com.task.Task.Repo.TaskCategoryRepo;
import com.task.Task.TaskCategoryDto.TaskCategoryRequest;
import com.task.Task.TaskCategoryDto.TaskCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskCategoryService {

    @Autowired
    TaskCategoryRepo taskCategoryRepo;


    public TaskCategoryResponse getTaskCategoryResponse(TaskCategory taskCategory){
        TaskCategoryResponse taskCategoryResponse=new TaskCategoryResponse();
        taskCategoryResponse.setTaskCategory(taskCategory.getTaskCategory());
        taskCategoryResponse.setId(taskCategory.getId());
        return taskCategoryResponse;
    }

    public TaskCategory createTaskCategory(TaskCategoryRequest taskCategoryRequest){

        TaskCategory taskCategory = new TaskCategory();
        taskCategory.setTaskCategory(taskCategoryRequest.getTaskCategory());
        taskCategoryRepo.save(taskCategory);
        return taskCategory;
    }

    public TaskCategory getTaskCategory(Long id){
        return taskCategoryRepo.findById(id).orElseThrow(RuntimeException::new);

    }

    public List<TaskCategoryResponse> getAllTaskCategory(){
        Iterable<TaskCategory> taskCategories= taskCategoryRepo.findAll();
        List<TaskCategoryResponse> taskCategoryResponses=new ArrayList<>();
        for(TaskCategory taskCategory: taskCategories){

            taskCategoryResponses.add(getTaskCategoryResponse(taskCategory));
        }
        return taskCategoryResponses;
    }

}
