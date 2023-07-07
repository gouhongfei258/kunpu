package com.sx.sports.mapper;

import com.sx.sports.entity.CommentPost;

import java.util.List;
import java.util.Map;

public interface CommentPostMapper {
    //点击帖子查看评论进行分页
    public List<CommentPost> findCommentById(Map<String,Object> map);

    //获取当前帖子下的帖子数量
    public int selectCount(Map<String,Object> map);

    //点赞评论
    public int updateLikes(int commentID);

    //删除评论?
    public int deleteComment(int commentID);

    //上传评论
    public int insertComment(CommentPost commentPost);

}
