package com.sx.sports;
import com.sx.sports.Controller.HelloController;
import com.sx.sports.mapper.PostMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.sx.sports.entity.Role;
import com.sx.sports.mapper.RoleMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import com.sx.sports.entity.Post;

/**class SportsApplicationTests {


	void contextLoads() {
	}

}**/

@SpringBootTest
class SportsApplicationTests {
	@Autowired
	private PostMapper postMapper;
	@Test
	public void testPageSelect(){
		System.out.println(postMapper.selectPostPage("2f"));

	}


}

