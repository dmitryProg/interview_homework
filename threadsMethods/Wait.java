public class Wait {
    static Object key = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.err.println(i);
                    if (i == 3) {
                        synchronized (key) {
                            key.notifyAll();
                        }
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        System.err.println("start...");
        thread.start();
        synchronized (key) {
            key.notifyAll();
        }
        System.err.println("finish...");
    }
}
