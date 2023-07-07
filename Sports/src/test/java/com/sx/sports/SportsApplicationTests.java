package com.sx.sports;
import com.sx.sports.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sx.sports.mapper.CommentPostMapper;

@SpringBootTest
class SportsApplicationTests {
	@Autowired
	private PostMapper postMapper;
	@Test
	/*public void testPageSelect(){
		Page page = new Page();  page.setPageSize(2);  page.setPageNum(1);
		Post post = new Post();  post.setTitle("r");
		//System.out.println(page.getPageSize());
		//System.out.println(page.getPageNum());
		Map map1 = new HashMap();
		Map map = new HashMap();
		map.put("page",page);
		map.put("post",post);
		map1.put("post",post);
		int totalNum = postMapper.selectCount(map1);
		page.setTotalNum(totalNum);

		System.out.println(totalNum);
		System.out.println(page.getTotalNum());
		//page limit index
		page.setLimitIndex(page.getLimitIndex());
		System.out.println(page.getLimitIndex());
		//pageCount
		page.setPageCount(page.getPageCount());
		System.out.println(page.getPageCount());

		//List<Post> list = postMapper.selectPostPage(map);
		System.out.println(postMapper.selectPostPage(map));
		System.out.println("通过！");

	}*/
	public void likesTest(){
		postMapper.updateLikes(2);
	}
	@Autowired
	private CommentPostMapper commentPostMapper;
	/*
	@Test
	public void testcommentSelect(){
		Page page = new Page();  page.setPageSize(2);  page.setPageNum(1);
		CommentPost commentPost = new CommentPost();  commentPost.setPostId(131);
		//System.out.println(page.getPageSize());
		//System.out.println(page.getPageNum());
		Map map1 = new HashMap();
		Map map = new HashMap();
		map.put("page",page);
		map.put("commentPost",commentPost);
		map1.put("commentPost",commentPost);
		int totalNum = commentPostMapper.selectCount(map1);
		page.setTotalNum(totalNum);

		System.out.println("查询符合条件的评论"+ totalNum);
		System.out.println("查询page传进去的totalNum"+ page.getTotalNum());
		//page limit index
		page.setLimitIndex(page.getLimitIndex());
		System.out.println("查询limitIndex参数"+ page.getLimitIndex());
		//pageCount
		page.setPageCount(page.getPageCount());
		System.out.println("查询页面数"+ page.getPageCount());

		//List<Post> list = postMapper.selectPostPage(map);
		System.out.println(commentPostMapper.findCommentById(map));
		System.out.println("通过！");

	}

	/*@Test
	public void uploadComment(){
		CommentPost commentPost = new CommentPost();
		commentPost.setContent("data");
		commentPost.setPostId(2);
		commentPost.setUserName("许晓明");
		commentPostMapper.insertComment(commentPost);
	}*/

	@Test
	public void addLikesTest(){
		commentPostMapper.updateLikes(1);
	}
}

