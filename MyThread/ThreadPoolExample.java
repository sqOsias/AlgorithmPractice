package MyThread;

import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        // 1. 创建线程池（核心线程数=2，最大线程数=4，队列容量=2，保活时间=30秒）
        ExecutorService executor = new ThreadPoolExecutor(
                2,   // 核心线程数
                4,   // 最大线程数
                30,  // 空闲线程保活时间
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),  // 任务队列容量
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()  // 拒绝策略：直接抛出异常
        );

        // 2. 提交10个任务到线程池
        for (int i = 1; i <= 10; i++) {
            final int taskId = i;
            try {
                executor.submit(() -> {
                    System.out.printf("任务 %d 正在执行，线程：%s%n",
                            taskId, Thread.currentThread().getName());
                    try {
                        Thread.sleep(1000); // 模拟任务耗时
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            } catch (RejectedExecutionException e) {
                System.err.println("任务 " + taskId + " 被拒绝（队列已满）");
            }
        }

        // 3. 关闭线程池（等待已有任务完成）
        executor.shutdown();
        try {
            // 等待所有任务完成，最多等待10秒
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.err.println("仍有任务未完成，强制关闭线程池");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}