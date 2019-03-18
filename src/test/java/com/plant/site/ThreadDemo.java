package com.plant.site;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019-02-18 10:28
 * @version:1.0
 **/
public class ThreadDemo {
    int count = 0; // 记录方法的命中次数

    public static void main(String[] args) {
        new ThreadDemo().threadMethod(1);
    }

    public void threadMethod(int j) {

        count++;

        int i = 1;

        j = j + i;
        System.out.println(count);
    }

}
