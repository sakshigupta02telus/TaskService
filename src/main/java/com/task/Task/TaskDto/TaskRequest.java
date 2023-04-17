package com.task.Task.TaskDto;
import com.task.Project.entity.Project;
import com.task.Task.Entity.TaskCategory;
import com.task.Task.Entity.TaskStatus;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Setter
@Getter
public class TaskRequest {


    @NotNull(message="ProjectId is required")
    private Long projectId;
    @NotNull(message="Task Title is required")
    private String title;
    @NotNull(message="Task description is required")
    private String description;

    private LocalDate dueDate;

    @NotNull(message="statusId is required")
    private Long statusId;

    @NotNull(message="assignedToId is required")
    private Long assignedToId;
    @NotNull(message="createdById is required")
    private Long createdById;
    private LocalDate createdOn;
    @NotNull(message="taskCategoryId is required")
    private Long taskCategoryId;

}