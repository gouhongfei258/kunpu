package com.sx.sports.Controller;

import com.sx.sports.entity.CommentPost;
import com.sx.sports.entity.Page;
import com.sx.sports.entity.Result;

import com.sx.sports.service.CommentPostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
/*
author:ghf
 */

//所有接口如下：
/*
查看帖子对应的评论： /comment/look-comment                    你得传入参数(Page page,CommentPost commentPost)
                                                                        page所必须参数:{
                                                                        PageSize:页面容纳大小
                                                                        PageNum: 当前所需的第几页
                                                                        }
                                                                        commentPost所必须参数：{
                                                                        postId:用来查询帖子下所有评论
                                                                        }

点赞评论：          /comment/giveLikes                       @PutMapping int commentID
删除评论：          /comment/delete-comment/{commentID}      @PathVariable Integer commentID
新增评论：          /comment/add-comment                     @PutMapping Commentpost commentPost
 */


@RequestMapping("/comment")
@RestController
public class CommentPostController {
    @Autowired
    private CommentPostService commentpostservice;


    //查看评论
    @GetMapping("/look-comment")
    public Result getComment(Page page, CommentPost commentPost){
        //帖子总数
        int totalNum = commentpostservice.selectCount(commentPost);
        page.setTotalNum(totalNum);

        // 根据条件查询
        List<CommentPost> commentPostList = commentpostservice.findCommentById(page, commentPost);
        page.setResultList(commentPostList);
        return Result.ok(page);
    }

    //点赞评论
    @PutMapping("/giveLikes")
    public Result addLikesComment(Integer commentID){
        return Result.ok(commentpostservice.updateLikes(commentID));
    }

    //删除评论
    @DeleteMapping("/delete-comment/{commentID}")
    public Result deleteComment(@PathVariable Integer commentID){
        commentpostservice.deleteComment(commentID);
        return Result.ok("评论已删除!");
    }
    //新增评论
    @PutMapping("/add-comment")
    public Result addComment(CommentPost commentPost){
        int effectRows = commentpostservice.insertPost(commentPost);
        if (effectRows >0)
            return Result.ok("评论成功！");
        else
            return Result.err(Result.CODE_ERR_DATABASE,"评论失败!");
    }

}