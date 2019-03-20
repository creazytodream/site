package com.plant.site;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(value = "com.plant.site.dao")
@EnableCaching
public class SiteApplication {

    public static void main(String[] args) {
        System.out.println("SiteApplication Starting .........");
        new SpringApplicationBuilder(SiteApplication.class).bannerMode(Banner.Mode.CONSOLE)
                .run(args);
        System.out.println("SiteApplication Started Success.......");
    }


}

