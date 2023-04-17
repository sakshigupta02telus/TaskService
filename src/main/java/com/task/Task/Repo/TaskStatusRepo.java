package com.task.Task.Repo;

import com.task.Task.Entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskStatusRepo extends JpaRepository <TaskStatus,Long> {

}
