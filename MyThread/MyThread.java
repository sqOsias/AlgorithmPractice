package MyThread;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("MyThread");
    }
    @Override
    public void start() {
        System.out.println("start");
        super.start();
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("main");

    }
}
