package com.sx.sports.mapper;

import com.sx.sports.entity.Role;
import com.sx.sports.entity.CommentPost;

import java.util.List;

public interface CommentPostMapper {
    //点击帖子查看评论
    public List<CommentPost> findCommentById(String postId);

    //点赞评论
    public int updateLikes(String commentID);

    //删除评论?
    public int deleteComment(String commentID);


}
