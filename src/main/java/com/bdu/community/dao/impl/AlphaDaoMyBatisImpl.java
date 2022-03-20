package com.bdu.community.dao.impl;

import com.bdu.community.dao.AlphaDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
//有两个bean优先使用这个
@Primary
public class AlphaDaoMyBatisImpl implements AlphaDao {
    @Override
    public String select() {
        return "mybatis";
    }
}
