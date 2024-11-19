package module12.emailservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ManyThreadsEmailService implements EmailService {

    private static ExecutorService sender;

    public ManyThreadsEmailService(int threadsQty){
        sender = Executors.newFixedThreadPool(threadsQty);
    }

    @Override
    public void sendEmail(Email email) {
        sender.execute(() -> sendOneEmail(email));
    }

    public void close(){
        sender.close();
    }

    private void sendOneEmail(Email email) {
        //todo some vendor logic
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(email);
    }

}
