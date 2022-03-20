package com.bdu.community;

import com.bdu.community.dao.DiscussPostMappper;
import com.bdu.community.dao.UserMapper;
import com.bdu.community.entity.DiscussPost;
import com.bdu.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
public class MapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private DiscussPostMappper discussPostMappper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);
        User liubei = userMapper.selectByName("liubei");
        System.out.println(liubei);
        User user1 = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user1);


    }
    @Test
    public void testInsertUser(){
        User user=new User();
        user.setUsername("test");
        user.setPassword("123456");
        user.setSalt("abc");
        user.setEmail("test@qq.com");
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());
        int i = userMapper.insertUser(user);
        System.out.println(i);
    }
    @Test
    public void testSlectPosts(){
        List<DiscussPost> discussPosts = discussPostMappper.selectDiscussPosts(149, 0, 10);
        for (DiscussPost discussPost : discussPosts) {
            System.out.println(discussPost.toString());
        }
        int i = discussPostMappper.selectBiscussPostRows(149);
        System.out.println(i);
    }

}
