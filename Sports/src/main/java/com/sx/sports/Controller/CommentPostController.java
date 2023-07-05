package com.sx.sports.Controller;

import com.sx.sports.entity.Result;

import com.sx.sports.service.CommentPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CommentPostController {
    @Autowired
    private CommentPostService commentpostservice;
    //查看评论
    @GetMapping("/comment")
    public Result getComment(String commentID){
        return Result.ok( commentpostservice.findCommentById(commentID));}

    //点赞评论
    @PutMapping("/giveLikes")
    public Result addLikesComment(String commentID){
        return Result.ok(commentpostservice.updateLikes(commentID));
    }

    //删除评论
    @DeleteMapping("/delete/{commentID}")
    public Result deletecomment(String commentID){
        return Result.ok(commentpostservice.deleteComment(commentID));
    }

}