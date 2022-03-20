package com.bdu.community.dao;

import com.bdu.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMappper {
    //复用 可以查单个id帖子   offset起始页行号     Limit 每页最多显示多少条数据
    List<DiscussPost> selectDiscussPosts(int userId,int offset,int limit);
    //查询帖子行数
    //@Param注解用于给参数取别名
    //如果只有一个参数，并且<if>里使用，则必须加别名
    int selectBiscussPostRows(@Param("userId") int userId);

}
