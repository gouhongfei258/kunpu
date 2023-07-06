package com.sx.sports.service.impl;

import com.sx.sports.entity.Page;
import com.sx.sports.entity.Post;
import com.sx.sports.mapper.PostMapper;
import com.sx.sports.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
    public List<Post> selectPostPage(Page page,Post post) {
        Map map = new HashMap();
        // map的key要和mapper.xml中保持一致
        map.put( "page" ,page);
        map.put("post" ,post);
        return postMapper.selectPostPage(map);}
//点赞
    @Override
    public int updateLikes(Integer postId) {
        return postMapper.updateLikes(postId);
    }

    //所有帖子数量
    @Override
    public int selectCount(Post post){
        Map map = new HashMap();
        map.put("post", post);
        return postMapper.selectCount(map);
    }
}
