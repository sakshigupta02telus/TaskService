package com.task.Task.TaskDto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
public class TaskResponse {

    private Long id;
    private String projectname;
    private String title;
    private String description;
    private LocalDate startDate;

    private LocalDate dueDate;
    private String status;
    private UserResponse assignedTo;
    private UserResponse createdBy;
    private LocalDate createdOn;
    private String taskCategory;
//    private Listof comment;

//    {
//        "id": 1,
//            "project_name": "ABC",
//            "title": "aaaaa",
//            "description": "asjkdhnsajdhas",
//            "assignedTo": {
//        "id": 1,
//                "username": "sakshi"
//    },
//        "createdBy": {
//        "id": 2,
//                "username": "ankit"
//    }
//    }

}
