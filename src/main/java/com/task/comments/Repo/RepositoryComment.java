package com.task.comments.Repo;
import com.task.Task.Entity.Task;
import com.task.comments.Entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryComment extends JpaRepository<Comments,Long> {

//    getCommentsByTaskid
    List<Comments> findByTaskOrderByCreatedOnDesc(Task task);
    //SELECT * FROM COMMENT WHERE TASKID=6;

}
