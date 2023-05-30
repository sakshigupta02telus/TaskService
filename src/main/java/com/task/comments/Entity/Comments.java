package com.task.comments.Entity;
import com.task.Task.Entity.Task;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.*;
import java.time.LocalDateTime;



@Setter
@Getter
@Entity
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 65450, columnDefinition = "text")
    private String comments;

    @CreationTimestamp
    private LocalDateTime createdOn;

    private Long commentedById;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "task_id")
    private Task task;

}
