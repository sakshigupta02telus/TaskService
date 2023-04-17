package com.task.Project.dto;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;


@Setter
@Getter
public class ProjectRequest {

    @NotNull(message="Project name is required")
    private String projectName;
    @NotNull(message="Project status is required")
    private Boolean isActive;
}
