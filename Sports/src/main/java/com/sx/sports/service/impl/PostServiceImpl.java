package com.sx.sports.service.impl;

import com.sx.sports.entity.Post;
import com.sx.sports.mapper.PostMapper;
import com.sx.sports.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostMapper postMapper;

//读取所有帖子
    @Override
    public List<Post> findAllPost() {
        return postMapper.findAllPost();
    }

//新建帖子
    @Override
    public int addPost(Post post) {
        return postMapper.addPost(post);
    }

//删帖子
    @Override
    public int deletePost(int postId) {
        return postMapper.deletePost(postId);
    }
//通过帖子ID查帖子
    @Override
    public Post findPostByCode(Integer PostId) {
        return postMapper.findPostByCode(PostId);
    }
//通过大概标题查询帖子
    @Override
    public List<Post> selectPostPage(String title) {
        return postMapper.selectPostPage(title);
    }
//点赞
    @Override
    public int updateLikes(Integer postId) {
        return postMapper.updateLikes(postId);
    }
}
