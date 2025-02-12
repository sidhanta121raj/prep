package com.poppulo.lottery.config;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OpenAPIConfigTests {

    @Autowired
    private ApplicationContext context;

    @Test
    void testPublicApiBean() {
        assertNotNull(context.getBean("publicApi"));
    }

    @Test
    void testSpringShopOpenAPIBean() {
        assertNotNull(context.getBean("springShopOpenAPI"));
    }
}
