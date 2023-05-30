package com.task.Task.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.task.Project.entity.Project;
import com.task.comments.Entity.Comments;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


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

    @CreationTimestamp
    private LocalDateTime createdOn;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id" )
    private TaskCategory category;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "task", cascade = CascadeType.ALL)
    private List<Comments> commentsList = new ArrayList<>();

}
