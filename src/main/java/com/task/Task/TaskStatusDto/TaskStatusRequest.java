package com.task.Task.TaskStatusDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Setter
@Getter
public class TaskStatusRequest {

    @NotNull(message="taskStatus is required")
    private String taskStatus;


}
