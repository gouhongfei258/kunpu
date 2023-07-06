package com.sx.sports;
import com.sx.sports.Controller.HelloController;
import com.sx.sports.entity.Page;
import com.sx.sports.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sx.sports.entity.Role;
import com.sx.sports.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sx.sports.entity.Post;
import com.sx.sports.mapper.CommentPostMapper;
import com.sx.sports.mapper.PostMapper;

@SpringBootTest
class SportsApplicationTests {
	@Autowired
	private PostMapper postMapper;
	@Test
	public void testPageSelect(){
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

	}


}

