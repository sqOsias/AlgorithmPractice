package MyThread;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("run\n");
    }

    public static void main(String[] args) {
//        new Thread(new MyRunnable()).start();
//        System.out.printf("main\n");;

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable");
            }
        };
        new Thread(runnable).start();
    }
}
