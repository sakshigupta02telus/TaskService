package com.task.Project.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.Task.Entity.Task;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="ProjectName")
    private String projectName;
    @Column(name="ProjectStatus")
    private Boolean isActive;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
    private List<Task> taskList = new ArrayList<>();

//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Task> tasklist;

}
