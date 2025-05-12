package MyThread;

/**
 * wrong
 */
public class ProductAndConsumer {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Thread(new Producer(container)).start();
        new Thread(new Consumer(container)).start();
    }
}


class Food {
    int id;

    public Food(int id) {
        this.id = id;
    }
}

class Producer implements Runnable {
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Food food = new Food(i);
            container.product(food);
            synchronized (container) {
                System.out.println("生产者生产了" + i);
            }
        }
    }
}

class Consumer implements Runnable {

    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Food food = container.consumer();
            synchronized (container) {
                System.out.println("-----消费者消费了" + food.id);
            }
        }
    }
}

class SynContainer {

    Food[] foods = new Food[10];
    int count = 0;

    public synchronized void product(Food food) {
        while (count == foods.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        foods[count++] = food;
        this.notifyAll();
    }

    public synchronized Food consumer() {
        while (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Food food = foods[--count];
        this.notifyAll();
        return food;
    }
}
