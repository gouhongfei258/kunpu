package com.sx.sports.service;


import com.sx.sports.entity.CommentPost;

import java.util.List;


public interface CommentPostService {
    //点击帖子查看评论
    public List<CommentPost> findCommentById(String commentID);

    //点赞评论
    public int updateLikes(String commentID);

    //删除评论?
    public int deleteComment(String commentID);


    }
