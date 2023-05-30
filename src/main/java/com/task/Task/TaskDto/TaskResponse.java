package com.task.Task.TaskDto;
import com.task.Project.entity.Project;
import com.task.Task.Entity.TaskCategory;
import com.task.Task.Entity.TaskStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
public class TaskResponse {
    private Long id;
    private Project project;
    private String title;
    private String description;
    private LocalDate dueDate;
    private TaskStatus status;
    private UserResponse assignedTo;
    private UserResponse createdBy;
    private LocalDateTime createdOn;
    private TaskCategory category;

}
