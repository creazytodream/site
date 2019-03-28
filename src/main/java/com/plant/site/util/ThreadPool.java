package com.plant.site.util;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @description: TODO
 * @author: yumingbin@zto.cn
 * @date: 2019-03-28 10:26
 * @version:1.0
 **/
@Component
public class ThreadPool {

    private ThreadPoolExecutor executor;

    @PostConstruct
    public void init() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();

        executor = new ThreadPoolExecutor((availableProcessors + 1) / 2, availableProcessors + 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>());
    }

    public void execute(Runnable runnable) {
        executor.execute(runnable);
    }



}
