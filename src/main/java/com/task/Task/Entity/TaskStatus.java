package com.task.Task.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Setter
@Getter
@Entity
@Table(name="task_status")
public class TaskStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String taskstatus;


    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "status", cascade = CascadeType.ALL)
    private List<Task> taskList = new ArrayList<>();
}
