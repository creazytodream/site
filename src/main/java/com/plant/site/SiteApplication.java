package com.plant.site;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value = "com.plant.site.dao")
//@ComponentScan("com.plant.site.controller")
public class SiteApplication {

    public static void main(String[] args) {
        System.out.println("SiteApplication Starting .........");
        new SpringApplicationBuilder(SiteApplication.class).bannerMode(Banner.Mode.CONSOLE)
                .run(args);
        System.out.println("SiteApplication Started Success.......");
    }

}

