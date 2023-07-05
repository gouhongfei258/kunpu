package com.sx.sports.Controller;

import com.sx.sports.entity.Result;
import com.sx.sports.entity.Page;
import com.sx.sports.entity.Post;
import com.sx.sports.service.PostService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;
//查询所有帖子
    @GetMapping("/allPost")
    public Result allPost(){
        return Result.ok(postService.findAllPost());}

//上传帖子
    @PutMapping("/addPost")
    public Result addPost(@RequestBody Post post){
        return Result.ok(postService.addPost(post));}

//删除帖子
    @DeleteMapping("/deletePost/{postId}")
    public Result deletePost(@PathVariable int postId){
        postService.deletePost(postId);
        return Result.ok("帖子已删除");
    }

//通过ID查找帖子
    @GetMapping("/findPost")
    public Result findPost(@RequestBody Integer postId){
        return Result.ok(postService.findPostByCode(postId));
    }
//通过大致标题找帖子
    @GetMapping("/findTitle")
    public Result findPostByTitle(@RequestBody Post post){
        String title = post.getTitle();
        return Result.ok(postService.selectPostPage(title));
    }



//点赞
    @PutMapping("/addLikes")
    public  Result addLikes(@RequestBody Integer postId){
           int updateRows = postService.updateLikes(postId);
           if(updateRows>0)
               return Result.ok("点赞成功");
           else
               return Result.err(Result.CODE_ERR_DATABASE,"点赞失败！");
    }


}