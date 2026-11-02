
private static final Lock lock = new ReentrantLock();
private static final Condition condition = lock.newCondition();
private static boolean dataReady = false;

void main() {

    Thread consumer = new Thread(() -> {
        lock.lock();
        try {
            while (!dataReady) {
                System.out.println("Consumer waiting...");
                condition.await(); // releases lock and waits
            }
            System.out.println("Consumer received data");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
        }
    });

    Thread producer = new Thread(() -> {
        lock.lock();
        try {
            System.out.println("Producer preparing data...");
            dataReady = true;

            condition.signal(); // wake up consumer
            System.out.println("Producer signaled consumer");
        } finally {
            lock.unlock();
        }
    });

    consumer.start();
    producer.start();

}