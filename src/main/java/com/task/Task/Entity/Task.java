package com.task.Task.Entity;
import com.task.Project.entity.Project;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;


@Setter
@Getter
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_id" )
    private Project  project;

    private String title;
    @Column(length = 65450 , columnDefinition = "text")
    private String description;

    private LocalDate dueDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id" )
    private TaskStatus status;
    private Long assignedToId;
    private Long createdById;

    private LocalDate createdOn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id" )
    private TaskCategory category;

}
