package com.bdu.community.dao.impl;

import com.bdu.community.dao.AlphaDao;
import org.springframework.stereotype.Repository;

@Repository("alphaHibernate")
public class AlphaDaoImpl implements AlphaDao {
    @Override
    public String select() {
        return "Hibernate";
    }
}
