package MyThread.unsafe;

public class unsafeBank {
    public static void main(String[] args) throws InterruptedException {
        Account account = new Account(1000, "Account");

        Drawing boy = new Drawing(800, "boy", account);
        Drawing girl = new Drawing(700, "girl", account);

        boy.start();
        girl.start();

    }
}

class Account {

    int money;
    String name;

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

class Drawing extends Thread {
    private Account account;
    private int drawMoney;
    private int leftMoney;

    public Drawing(int drawMoney, String name, Account account) {
        super(name);
        this.drawMoney = drawMoney;

        this.account = account;
    }

    @Override
    public void run() {
        synchronized (account){
            if (drawMoney > account.money) {
                System.out.println(Thread.currentThread().getName()+"want money"+drawMoney+"but only have "+account.money);
                return;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            account.money -= drawMoney;
            leftMoney += drawMoney;
            System.out.println(account.name + "余额为" + account.money);
            System.out.println(Thread.currentThread().getName()+ " own " + leftMoney);
        }

    }
}
