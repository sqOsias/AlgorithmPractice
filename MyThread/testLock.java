package MyThread;

import java.util.concurrent.locks.ReentrantLock;

public class testLock {
    public static void main(String[] args) {
        Lock1 lock1 = new Lock1();
        new Thread(lock1 ).start();
        new Thread(lock1 ).start();
        new Thread(lock1 ).start();

    }

}
class Lock1 implements Runnable{

    int count = 10;
    private final ReentrantLock lock = new ReentrantLock();
    @Override
    public void run() {
        while(true){
            try{
                lock.lock();
                if (count>0){

                    System.out.println(Thread.currentThread().getName()+"-----"+count--);
                }else{
                    break;
                }
            }finally {
                lock.unlock();
            }
        }

    }
}