package com.task.Task.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;


@Setter
@Getter
@AllArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
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
//    private Long commentId;       (MTO1) COMMENT ENTITY --TASKID
}
