package MyThread.unsafe;

import java.util.ArrayList;

public class unsafeList {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000; i++){
            new Thread(()->{
                synchronized (strings){
                    strings.add(Thread.currentThread().getName());
                }

            }).start();
        }
        Thread.sleep(1000);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

        System.out.println(strings.size());
    }
}
