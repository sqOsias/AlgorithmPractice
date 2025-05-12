package MyThread;

public class TestStop implements Runnable{
    boolean flag=true;
    @Override
    public void run() {
        for (int i = 0; i < 100; i++){
            if(flag){
                System.out.println(Thread.currentThread().getName()+" "+i);
            }
        }
    }
    public void stop(){
        flag=false;
    }


    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop).start();

        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+" "+i);
            if(i==90){
                testStop.stop();
                System.out.println("----------stop----------");
            }
        }
    }
}
