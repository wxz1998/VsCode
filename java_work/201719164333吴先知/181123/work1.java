public class work1 {
    public static void main(String[] args) {
        Runnable printA = new printCharA('A', 20);
        Runnable printB = new printCharB('B', 10);
        Thread threadA = new Thread(printA);
        Thread threadB = new Thread(printB);
        threadA.start();
        threadB.start();
    }

    static class printCharA implements Runnable {
        char chs;
        int times;

        public printCharA(char chs, int times) {
            this.chs = chs;
            this.times = times;
        }

        public void run() {
            for (int i = 0; i < times; i++) {
                try {
                    if (i == 9) {
                        Thread threadC = new Thread();
                        threadC.start();
                        for (int j = 0; j < 3; j++) {
                            try {
                                System.out.print('C');
                                Thread.sleep(3000);
                            } catch (InterruptedException E) {
                                E.printStackTrace();
                            }
                        }

                    }
                    System.out.print(chs);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class printCharB implements Runnable {
        char chs;
        int times;

        public printCharB(char chs, int times) {
            this.chs = chs;
            this.times = times;
        }

        public void run() {
            for (int i = 0; i < times; i++) {
                try {
                    System.out.print(chs);
                    Thread.sleep(2000);
                } catch (InterruptedException E) {
                    E.printStackTrace();
                }
            }
        }
    }
}