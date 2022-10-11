package com.mall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author：陈迎鹏
 * @Description TODO
 * @since 1.0.0
 */
@SpringBootApplication
@MapperScan("com.mall.user.dao")
public class MallUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallUserApplication.class);
    }
}
