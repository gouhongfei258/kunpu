package com.sx.sports.service;

import com.sx.sports.entity.Page;
import com.sx.sports.entity.Post;


import java.util.List;
import java.util.Map;


public interface PostService {

    //return all posts
    public List<Post> findAllPost();

    //add a post
    public int addPost(Post post);

    //delete your post
    public int deletePost(int postId);

    //find a post by post_id
    public Post findPostByCode(Integer PostId);

    //find  post by title and divided page
    public List<Post> selectPostPage(Page page,Post post);

    //add likes to a post
    public int updateLikes(Integer postId);

    /**
     * 查询帖子个数
     */
    public int selectCount(Post post);

}
