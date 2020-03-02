public class ProducerConsumerTest {
    public static void main(String[] args) {
        MessagePool pool = new MessagePool(10); // init with size of Pool

        Producer p1 = new Producer(pool, "P1", 100); // msgPool, name, amount of msg.
        Consumer c1 = new Consumer(pool, "C1", 100);
        p1.start();
        c1.start();

        Producer p2 = new Producer(pool, "P2", 100); // msgPool, name, amount of msg.
        Consumer c2 = new Consumer(pool, "C2", 100);
        p2.start();
        c2.start();

        Producer p3 = new Producer(pool, "P3", 100); // msgPool, name, amount of msg.
        Consumer c3 = new Consumer(pool, "C3", 100);
        p3.start();
        c3.start();
    }
}