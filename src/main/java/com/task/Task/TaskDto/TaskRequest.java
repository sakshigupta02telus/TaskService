package com.task.Task.TaskDto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
public class TaskRequest {


    @NotNull(message="ProjectId is required")
    private Long projectId;

    @NotNull(message="Task Title is required")
    @NotEmpty(message="Task Title cannot be empty")
    private String title;

    @NotNull(message="Task description is required")
    @NotEmpty(message="Task Title cannot be empty")
    private String description;

    private LocalDate dueDate;

    @NotNull(message="statusId is required")
    private Long statusId;

    @NotNull(message="assignedToId is required")
    private Long assignedToId;
    @NotNull(message="createdById is required")
    private Long createdById;

    @NotNull(message="taskCategoryId is required")
    private Long taskCategoryId;

}
