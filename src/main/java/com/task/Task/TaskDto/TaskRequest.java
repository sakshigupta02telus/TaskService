package com.task.Task.TaskDto;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Calendar;

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

    @NotNull(message="taskCategoryId is required")
    private Long taskCategoryId;

}
