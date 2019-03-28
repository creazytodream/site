package com.plant.site;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019-03-28 10:01
 * @version:1.0
 **/
public class SharedVariableThread extends Thread {

    public int count = 5;

    @Override
    public void run() {
        super.run();
        count--;
        synchronized ((Object) count){

        }
        System.out.println("由 " + SharedVariableThread.currentThread().getName() + " 计算，count=" + count);
    }

    public static void main(String[] args) {

        SharedVariableThread mythread = new SharedVariableThread();
        // 下列线程都是通过mythread对象创建的
        Thread a = new Thread(mythread, "A");
        Thread b = new Thread(mythread, "B");
        Thread c = new Thread(mythread, "C");
        Thread d = new Thread(mythread, "D");
        Thread e = new Thread(mythread, "E");
        a.start();
        b.start();
        c.start();
        d.start();
        e.start();
    }
}
