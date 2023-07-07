package com.sx.sports.mapper;
import com.sx.sports.entity.Post;
import java.util.List;
import java.util.Map;


public interface PostMapper {
    //return all posts
    public List<Post> findAllPost();

    //add a post
    public int addPost(Post post);

    //delete your post
    public int deletePost(int PostId);

    //find a post by post_id

    public Post findPostByCode(Integer PostId);

    //find  posts by title
    public List<Post> selectPostPage(Map map);

    //give likes to post
    public int updateLikes(Integer PostId);

    //count post numbers
    public int selectCount(Map<String ,Object> map);
}
