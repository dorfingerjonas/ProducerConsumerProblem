import java.util.concurrent.Semaphore;

public class MessagePool {

    String[] buffer;
    Semaphore itemsProduced;
    Semaphore emptySpace;
    int indexGet = 0;
    int indexPut = 0;
    /**
     * Constructor MessagePool with size of store as parameter
     * @param size
     */
    public MessagePool(int size) {
        itemsProduced = new Semaphore(0);
        emptySpace = new Semaphore(size);
        buffer = new String[size];
    }



    /***
     * get() is used from the consumer
     * @return
     */
    public String get() {
        String value = "";

        try {
            itemsProduced.acquire();
            synchronized (this) {
                value = buffer[indexGet++ % buffer.length];
            }
            emptySpace.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return value;
    }

    /***
     * put is used from the producer to put an object to the data pool
     * @param value
     */
    public void put(String value) {
        try {
            emptySpace.acquire();
            synchronized (this) {
                buffer[indexPut++ % buffer.length] = value;
            }
            itemsProduced.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}