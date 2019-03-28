package com.plant.site;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value = "com.plant.site.dao")
@EnableCaching
@EnableAsync
@EnableTransactionManagement
public class SiteApplication {

    public static void main(String[] args) {
        System.out.println("SiteApplication Starting .........");
        new SpringApplicationBuilder(SiteApplication.class).bannerMode(Banner.Mode.CONSOLE)
                .run(args);
        System.out.println("SiteApplication Started Success.......");
    }


}

