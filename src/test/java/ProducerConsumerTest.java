public class ProducerConsumerTest {

    public static void main(String[] args) {

        MessagePool pool = new MessagePool(10); // init with size of Pool

        Producer p1 = new Producer(pool, "P1", 100); // msgPool, name, amount of msg.
        Consumer c1 = new Consumer(pool, "C1", 100);
        p1.start();
        c1.start();

        // TODO: add more consumers
        //new Consumer(pool, "C2", 50).start();

        // TODO: add more producers
        //new Producer(pool, "P2", 50).start();
    }
}