package com.sx.sports.service;
import com.sx.sports.entity.CommentPost;
import java.util.List;

import com.sx.sports.entity.Page;

public interface CommentPostService {
    //点击帖子查看评论
    public List<CommentPost> findCommentById(Page page, CommentPost commentPost);

    //点赞评论
    public int updateLikes(int commentID);

    //删除评论?
    public int deleteComment(int commentID);

    //选择评论数量
    public int selectCount(CommentPost commentpost);

    //上传帖子
    public int insertPost(CommentPost commentPost);

    }
