package com.task.Task.Repo;
import com.task.Task.Entity.TaskCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskCategoryRepo extends JpaRepository<TaskCategory,Long> {


}
