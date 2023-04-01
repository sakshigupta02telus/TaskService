package com.task.Task.TaskDto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class TaskRequest {

    @NotNull
    private Long  projectId;
    private String title;
    private String description;
    private LocalDate startDate;

    private LocalDate dueDate;
    private Long statusId;
    private Long assignedToId;
    private Long createdById;
    private LocalDate createdOn;
    private Long taskCategoryId;
    private Long commentId;
}
