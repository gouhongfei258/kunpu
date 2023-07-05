package com.sx.sports.service.impl;

import com.sx.sports.entity.CommentPost;
import com.sx.sports.mapper.CommentPostMapper;
import com.sx.sports.service.CommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentPostServiceImpl implements CommentPostService {
    @Autowired
    private CommentPostMapper commentPostMapper;

    @Override
    public List<CommentPost> findCommentById(String postId) {

        return commentPostMapper.findCommentById(postId);
    }

    @Override
    public int updateLikes(String commentID) {
        return commentPostMapper.updateLikes(commentID);
    }

    @Override
    public int deleteComment(String commentID) {
        return commentPostMapper.deleteComment(commentID);
    }
}
