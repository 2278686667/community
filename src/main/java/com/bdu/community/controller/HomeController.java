package com.bdu.community.controller;

import com.bdu.community.entity.DiscussPost;
import com.bdu.community.entity.Page;
import com.bdu.community.entity.User;
import com.bdu.community.service.DiscussPostService;
import com.bdu.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    private DiscussPostService discussPostSrvice;
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String getIndexPage(Model model, Page page){
        //方法调用前，Springmvc会自动实例化Model和Page,并将Page注入到Model
        //所以,在thymeleat中可以直接访问Page对象中的数据
        page.setRows(discussPostSrvice.findDiscussPostRows(0));
        page.setPath("/index");


        List<DiscussPost> list = discussPostSrvice.findDiscussPosts(0, page.getOffset(), page.getLimit());
        List<Map<String,Object>> discussPosts=new ArrayList<>();
        if (list!=null){
            for (DiscussPost post:list){
                Map<String,Object> map=new HashMap<>();
                map.put("post",post);
                User user = userService.findUserById(post.getUserId());
                map.put("user",user);
                discussPosts.add(map);
            }
        }

        model.addAttribute("discussPosts",discussPosts);
        model.addAttribute("page",page);
        return "/index";
    }
}
