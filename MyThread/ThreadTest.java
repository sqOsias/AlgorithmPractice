package MyThread;

public class ThreadTest implements Runnable{
    private int ticks = 30;
    
    @Override
    public void run() {
        while(ticks>0){
            System.out.println(Thread.currentThread().getName()+"-->"+ticks--);
        }
    }
    public static void main(String[] args) {

        ThreadTest threadTest = new ThreadTest();
        Thread thread1 = new Thread(threadTest,"线程1");
        Thread thread2 = new Thread(threadTest,"线程2");
        Thread thread3 = new Thread(threadTest,"线程3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}
