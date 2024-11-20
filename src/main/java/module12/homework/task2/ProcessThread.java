package module12.homework.task2;

class ProcessThread extends Thread {
    private int number;
    private boolean processed = true;
    private final NumberProcessor processor;

    public ProcessThread(NumberProcessor processor) {
        this.processor = processor;
    }

    public boolean getProcessed(){
        return this.processed;
    }

    public void checkNumber(int number) {
        this.number = number;
        this.processed = false;
    }

    @Override
    public void run() {
        // run endless loop to check if the number is processed
        while (true) {
            // wait some time between checking
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // if the number is processed, continue
            if (processed) {
                continue;
            }

            // is the number is not processed, process it and set processed-pointer true
            this.processor.process(number);
            this.processed = true;
        }
    }
}
