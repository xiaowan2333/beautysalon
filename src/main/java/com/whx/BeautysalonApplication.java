package com.whx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: XiaoWan
 * @Date: 2022/5/14 11:41
 */
@SpringBootApplication
@MapperScan("com.whx.dao")
public class BeautysalonApplication {
    public static void main(String[] args) {
        SpringApplication.run(BeautysalonApplication.class,args);
    }
}
