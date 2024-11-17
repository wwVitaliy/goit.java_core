package module12;

class TryMultithreading {
    public static void main(String[] args) throws InterruptedException {

        HelloThread helloThread = new HelloThread();
        helloThread.start();

        Thread runningTextThread = new Thread(() -> {
            String dots = "";
            while (true) {
                System.out.println("Running " + dots);

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                if (dots.length() < 5) {
                    dots += ".";
                } else {
                    dots = "";
                }
            }

        });
        runningTextThread.setDaemon(true);
        runningTextThread.start();


        while (true) {
            System.out.println("hey...");
            Thread.sleep(5000);
        }

    }

    private static class HelloThread extends Thread {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Hello!!!");
            }
        }
    }

}
