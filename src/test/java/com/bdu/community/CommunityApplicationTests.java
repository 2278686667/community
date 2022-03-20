package com.bdu.community;

import com.bdu.community.config.AlphaConfig;
import com.bdu.community.dao.AlphaDao;
import com.bdu.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
//使用spring配置文件
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware{
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
    @Test
    void contextLoads() {
        AlphaDao bean = applicationContext.getBean(AlphaDao.class);
        System.out.println(bean.select());
        bean=applicationContext.getBean("alphaHibernate",AlphaDao.class);
        System.out.println(bean.select());
    }
    @Test
    public void testBeanManagement(){
        AlphaService alphaService=applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
        System.out.println(applicationContext.getBean(AlphaService.class));
    }
    @Test
    public void testBeanConfig(){
//        AlphaConfig simpleDateFormat = applicationContext.getBean(AlphaConfig.class);
//        System.out.println(simpleDateFormat.simpleDateFormat1());
        SimpleDateFormat bean = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(bean.format(new Date()));
    }
    @Autowired
    private AlphaDao alphaDao;

    @Autowired
    private AlphaConfig alphaConfig;
    @Test
    public void testDI(){
        String select = alphaDao.select();
        System.out.println(select);
        System.out.println(alphaConfig.simpleDateFormat1());
    }



//    @Test
//    void test01(){
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext(CommunityApplication.class);
//    }
//    @Autowired
//    private AlphaDaoImpl alphaDao;
//    @Test
//    void test(){
//        String select = alphaDao.select();
//        System.out.println(select);
//    }
}
