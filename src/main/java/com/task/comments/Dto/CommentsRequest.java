package com.task.comments.Dto;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;

@Setter
@Getter
public class CommentsRequest {

    @NotNull(message="comment is required")
    private String comments;

    @NotNull(message="commented is required")
    private Long commentedById;

    @NotNull(message="taskId is required")
    private Long taskId;

}
