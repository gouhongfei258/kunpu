package com.sx.sports.Controller;
import com.sx.sports.entity.Result;
import com.sx.sports.entity.Page;
import com.sx.sports.entity.Post;
import com.sx.sports.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/*
author:ghf
*/
//所有接口如下：
/*
查询所有帖子：    /post/allPost
上传帖子:        /post/addPost                 @RequestBody  Post post
删除帖子：       /post/deletePost/{postId}      @PathVariable int postId
通过ID查找帖子：  /post/findPost               @RequestBody int postId
通过大致的标题查找帖子：/post/findByTitle        你得传入（Page page,Post post）
【sql语句类似："%"title"%"】                         page所必需参数：
                                                { PageSize:页面容纳大小
                                                  PageNum: 当前所需的第几页
                                                  }
                                                post所必需参数:
                                                { title: 当前帖子的标题
                                                }

点赞某个帖子：    /addLikes/{postId}         @PathVariable int postId

 */



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
    @GetMapping("/findByTitle")
    public Result findPostByTitle(Page page,Post post){
        //帖子总数
        int totalNum = postService.selectCount(post);
        page.setTotalNum(totalNum);

        // 根据条件查询
        List<Post> userList = postService.selectPostPage(page, post);
        page.setResultList(userList);
        return Result.ok(page);
    }


    //点赞
    @PutMapping("/addLikes/{postId}")
    public  Result addLikes(@PathVariable Integer postId){
           int updateRows = postService.updateLikes(postId);
           if(updateRows>0)
               return Result.ok("点赞成功");
           else
               return Result.err(Result.CODE_ERR_DATABASE,"点赞失败！");
    }


}
