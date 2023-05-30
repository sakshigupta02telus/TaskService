package com.task.comments.Dto;
import com.task.Task.Entity.Task;
import com.task.Task.TaskDto.UserResponse;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;


@Setter
@Getter
public class CommentsResponse {

    private Long id;
    private String comments;
    private LocalDateTime createdOn;
    private UserResponse commentedBy;

//    private Task task;
}
