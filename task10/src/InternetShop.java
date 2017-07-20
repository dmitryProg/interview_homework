public class InternetShop {
    private static int cash = 500;

    public static void main(String[] args) {
        System.err.println("Your balance is " + cash);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.err.println("Barsik");
                for (int i = 0; i < 4; i++) {
                    buySausage();
                }
            }
        }).start();
    }

    private synchronized static void buySausage() {
        if (cash >= 250) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cash -= 250;
            System.err.println("OK, DONE, your cash is enough and it's = " + cash);
        } else {
            System.out.println("Not enough money for sausage!");
        }
    }
}
