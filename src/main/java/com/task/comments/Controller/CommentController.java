package com.task.comments.Controller;
import com.task.comments.Dto.CommentsRequest;
import com.task.comments.Dto.CommentsResponse;
import com.task.comments.Entity.Comments;
import com.task.comments.Services.CommentsServices;
import com.task.common.services.InternalApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    InternalApiService internalApiService;

    @Autowired
    CommentsServices commentsServices;


    @PostMapping
    public CommentsResponse createComments(@RequestBody CommentsRequest commentsRequest){
        Comments comments = commentsServices.createComments(commentsRequest);
        return commentsServices.getCommentsResponse(comments);
    }

    @GetMapping("/{id}")
    public CommentsResponse getComments(@PathVariable Long id){
        Comments comments = commentsServices.getComments(id);
        return commentsServices.getCommentsResponse(comments);
    }

    @GetMapping("/task/{id}")
    public List<CommentsResponse> getAllCommentsByTaskId(@PathVariable Long taskid){
        List<CommentsResponse> commentsResponses=commentsServices.getAllCommentsByTaskId(taskid);
        return commentsResponses;
    }

}
