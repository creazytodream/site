package com.plant.site;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019-03-28 10:08
 * @version:1.0
 **/
public class InterruptThread2 extends  Thread {

    @Override
    public void run() {
        super.run();
        int priority = this.getPriority();

        for (int i = 0; i < 3; i++) {
            System.out.println(priority);
            if (this.isInterrupted()) {
                System.out.println("已经是停止状态了!我要退出了!");
                return;
            }
            System.out.println("i=" + (i + 1));
        }
        System.out.println("看到这句话说明线程并未终止------");
    }

    public static void main(String[] args) {
        try {
            InterruptThread2 thread = new InterruptThread2();
            thread.start();
            Thread.sleep(2000);
            thread.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
    }
}
