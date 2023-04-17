package com.task.Task.TaskCategoryDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class TaskCategoryRequest {

    @NotNull(message="taskCategory name is required")
    private String taskCategory;

}
