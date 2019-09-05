package com.cloud.servicehi;

import com.cloud.servicehi.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceHiApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void contextLoads() {
        System.out.println(userService.findById("1"));
    }

}
