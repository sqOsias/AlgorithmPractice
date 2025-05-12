package MyThread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep implements Runnable{
    private int ticketNums = 20;

    @Override
    public void run() {

        while(true){
            if(ticketNums<=0){
                break;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            System.out.println(Thread.currentThread().getName()+"-----拿到了第"+ticketNums--+"票");
        }

    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();

        new Thread(testSleep,"小明").start();
        new Thread(testSleep,"老师").start();
        new Thread(testSleep,"黄牛党").start();

        Date date = new Date(System.currentTimeMillis());
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));

    }
}
