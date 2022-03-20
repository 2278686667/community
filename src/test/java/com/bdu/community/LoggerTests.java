package com.bdu.community;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LoggerTests {
    private static final Logger logger= LoggerFactory.getLogger(LoggerTests.class);
    @Test
    public void testLogger(){
        System.out.println(logger.getName());
        logger.debug("debuglog");
        logger.info("infolog");
        logger.warn("warlog");
        logger.error("errorlog");
    }
}
