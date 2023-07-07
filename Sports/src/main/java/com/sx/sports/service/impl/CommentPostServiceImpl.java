package com.sx.sports.service.impl;

import com.sx.sports.entity.CommentPost;
import com.sx.sports.entity.Page;
import com.sx.sports.mapper.CommentPostMapper;
import com.sx.sports.service.CommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentPostServiceImpl implements CommentPostService {
    @Autowired
    private CommentPostMapper commentPostMapper;

    @Override
    public List<CommentPost> findCommentById(Page page, CommentPost commentPost) {
        Map map = new HashMap();
        map.put("page",page);
        map.put("commentPost",commentPost);
        return commentPostMapper.findCommentById(map);
    }

    @Override
    public int updateLikes(int commentID) {
        return commentPostMapper.updateLikes(commentID);
    }

    @Override
    public int deleteComment(int commentID) {
        return commentPostMapper.deleteComment(commentID);
    }

    @Override
    public int selectCount(CommentPost commentpost) {
        Map map = new HashMap();
        //与mapper.xml一致
        map.put("commentPost",commentpost);
        return commentPostMapper.selectCount(map);

    }

    @Override
    public int insertPost(CommentPost commentPost) {
        return commentPostMapper.insertComment(commentPost);
    }


}
