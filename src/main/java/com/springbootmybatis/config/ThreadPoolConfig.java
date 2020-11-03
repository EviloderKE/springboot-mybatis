package com.springbootmybatis.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class ThreadPoolConfig {

    /**
     * 默认taskExecutor
     * @return
     */
    @Bean("asyncTaskExecutor")
    public AsyncTaskExecutor asyncTaskExecutor() {
        ThreadPoolTaskExecutor asyncTaskExecutor = new ThreadPoolTaskExecutor();
        // 最大线程数
        asyncTaskExecutor.setMaxPoolSize(50);

        // 核心线程数
        asyncTaskExecutor.setCorePoolSize(20);

        asyncTaskExecutor.setQueueCapacity(200);

        asyncTaskExecutor.setThreadNamePrefix("thread-pool-");

        // 当最大池已满时，此策略保证不会丢失任务请求，但是可能会影响应用程序整体性能。
        /*
         * Spring 默认使用的是 ThreadPoolExecutor.AbortPolicy。在Spring的默认情况下，ThreadPoolExecutor
         * 将抛出 RejectedExecutionException 来拒绝新来的任务 ，这代表你将丢失对这个任务的处理。 对于可伸缩的应用程序，
         * 建议使用 ThreadPoolExecutor.CallerRunsPolicy。当最大池被填满时，此策略为我们提供可伸缩队列。
         */
        asyncTaskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());

        asyncTaskExecutor.initialize();
        return asyncTaskExecutor;
    }

}
