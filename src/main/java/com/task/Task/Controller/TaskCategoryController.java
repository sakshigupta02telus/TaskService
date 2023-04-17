package com.task.Task.Controller;
import com.task.Task.Entity.TaskCategory;
import com.task.Task.Service.TaskCategoryService;
import com.task.Task.TaskCategoryDto.TaskCategoryRequest;
import com.task.Task.TaskCategoryDto.TaskCategoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/taskcategory")
public class TaskCategoryController {

    @Autowired
    TaskCategoryService taskCategoryService;

    @PostMapping
    public TaskCategoryResponse createTaskCategory(@Valid @RequestBody TaskCategoryRequest taskCategoryRequest){

        TaskCategory taskCategory= taskCategoryService.createTaskCategory(taskCategoryRequest);
        return taskCategoryService.getTaskCategoryResponse(taskCategory);
    }

    @GetMapping("/{id}")
    public TaskCategoryResponse getTaskCategory(@PathVariable Long id){
        TaskCategory taskCategory = taskCategoryService.getTaskCategory(id);
        return taskCategoryService.getTaskCategoryResponse(taskCategory);

    }

    @GetMapping
    public List<TaskCategoryResponse>getAllTaskCategory(){
        List<TaskCategoryResponse> taskCategoryResponses= taskCategoryService.getAllTaskCategory();
        return taskCategoryResponses;
    }

}
