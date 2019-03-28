package com.plant.site;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019-03-28 10:06
 * @version:1.0
 **/
public class MyThread extends  Thread {

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5000000; i++) {
            System.out.println("i=" + (i + 1));
        }
    }
    public static void main(String[] args) {
        try {
            MyThread thread = new MyThread();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
