package com.plant.site;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019-03-18 15:05
 * @version:1.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class CacheTest {


    @Test
    public void get() {
        Map map=new HashMap();
        System.out.println(map);
    }
}
