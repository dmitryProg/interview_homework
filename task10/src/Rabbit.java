import java.io.IOException;

public class Rabbit {
    public static boolean isEating = false;

    public static void main(String[] args) {
        new RabbitFlagSetter().start();
    }

    public static class RabbitFlagSetter extends Thread {
        @Override
        public void run() {
            try {
                int inputValue = System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            isEating = true;
            System.err.println("The rabbit is eating!");
        }
    }

}
