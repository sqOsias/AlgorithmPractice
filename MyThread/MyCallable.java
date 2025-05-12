package MyThread;

import java.util.concurrent.*;

public class MyCallable implements Callable<Boolean> {
    @Override
    public Boolean call() throws Exception {
        System.out.println("call");
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        //创建服务
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> submit = executorService.submit(myCallable);
        //获取结果
        Boolean b = submit.get();
        System.out.println(b);
        //关闭服务
        executorService.shutdown();

    }
}
