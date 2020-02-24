public class Consumer extends Thread {

    private final MessagePool _messagePool;
    private String _consumerName;
    private int _consumeAmount;

    public Consumer(MessagePool pool, String name, int consumption) {
        _messagePool = pool;
        _consumerName = name;
        _consumeAmount = consumption;
    }

    @Override
    public void run() {
        String value = "";
        for (int i = 0; i < _consumeAmount; i++) {
            // fetch message from the pool
            value = _messagePool.get();
            System.out.println("Consumer " + this._consumerName + " got: " + value);

            try {
                // Consumption of something from the pool needs some time
                sleep((int) (Math.random() * 200)); // production needs some time
            } catch (InterruptedException e) {
            }

        }
    }
}