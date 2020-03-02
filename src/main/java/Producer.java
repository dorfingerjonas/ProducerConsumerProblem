public class Producer extends Thread {

    private final MessagePool _messagePool;
    private String _producerName;
    private int _productionAmount;

    public Producer(MessagePool pool, String name, int productionAmount) {
        _messagePool = pool;
        _producerName = name;
        _productionAmount = productionAmount;
    }

    @Override
    public void run() {
        String msg = "";
        for (int i = 1; i <= _productionAmount; i++) {

            try {
                // Produce something and put it to the pool
                sleep((int) (Math.random() * 100)); // production needs some time
                msg = "Msg:(" + i + ") from " + _producerName;
            } catch (InterruptedException e) {
            }


            _messagePool.put(msg);
            System.out.println("Producer " + _producerName + " put: " + msg);

        }
    }
}