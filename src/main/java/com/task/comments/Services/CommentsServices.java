package com.task.comments.Services;
import com.task.Task.Entity.Task;
import com.task.Task.Repo.TaskRepository;
import com.task.Task.TaskDto.UserResponse;
import com.task.comments.Dto.CommentsRequest;
import com.task.comments.Dto.CommentsResponse;
import com.task.comments.Entity.Comments;
import com.task.comments.Repo.RepositoryComment;
import com.task.common.services.InternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentsServices {


    @Autowired
    TaskRepository taskRepository;

    @Autowired
    RepositoryComment repositoryComment;

    @Autowired
    InternalApiService internalApiService;
    public CommentsResponse getCommentsResponse(Comments comments){
        UserResponse commentedBy = internalApiService.getUser(comments.getCommentedById());
        CommentsResponse commentsResponse = new CommentsResponse();
        commentsResponse.setComments(comments.getComments());
        commentsResponse.setId(comments.getId());
        commentsResponse.setCreatedOn(comments.getCreatedOn());
        commentsResponse.setCommentedBy(commentedBy);
//        commentsResponse.setTask(comments.getTask());
        return commentsResponse;
    }

    public Comments createComments(CommentsRequest commentsRequest){

        Task task = taskRepository.findById(commentsRequest.getTaskId()).orElseThrow(RuntimeException::new);
        internalApiService.getUser(commentsRequest.getCommentedById());
        Comments comments = new Comments();
        comments.setCommentedById(commentsRequest.getCommentedById());
        comments.setComments(commentsRequest.getComments());
        comments.setTask(task);
        repositoryComment.save(comments);
        return comments;
    }

    public Comments getComments(Long id){
        return repositoryComment.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<CommentsResponse> getAllCommentsByTaskId(Long taskid){

        Task task = taskRepository.findById(taskid).orElseThrow(RuntimeException::new);
        List<Comments> comments =  repositoryComment.findByTask(task);
        List<CommentsResponse> commentsResponses = new ArrayList<>();
        for(Comments comment : comments){
            commentsResponses.add(getCommentsResponse(comment));
        }
        return commentsResponses;
    }




}
