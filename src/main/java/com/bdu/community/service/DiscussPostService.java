package com.bdu.community.service;

import com.bdu.community.dao.DiscussPostMappper;
import com.bdu.community.entity.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMappper discussPostMappper;

    public List<DiscussPost> findDiscussPosts(int userId,int offset,int limit){
        return discussPostMappper.selectDiscussPosts(userId,offset,limit);
    }
    public int findDiscussPostRows(int userId){
        return discussPostMappper.selectBiscussPostRows(userId);
    }
}
