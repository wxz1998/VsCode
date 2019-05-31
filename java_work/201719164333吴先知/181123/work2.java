public class work2 {
    public static void main(String[] args) {
        Runnable food1 = new printFood1();
        Thread thread1 = new Thread(food1);
        thread1.setDaemon(true);
        thread1.start();
    }

    static class printFood1 implements Runnable {

        public printFood1() {
        }

        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                    System.out.print("土豆炖牛肉");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
