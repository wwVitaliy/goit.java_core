package module12.emailservice;

import java.util.ArrayList;
import java.util.List;

class EmailTests {
    public static void main(String[] args) {
        // create emails
        List<Email> emails = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            emails.add(new Email("some text for " + i, "someAddress-" + i + "@email" ));
        }

        // send emails and continue execution
//        sendEmailsThroughMainThread(emails);
        sendEmailsThroughExecutor(emails);

    }

    private static void sendEmailsThroughExecutor(List  <Email> emails) {
        ManyThreadsEmailService emailService = new ManyThreadsEmailService(5);

        for (Email email : emails) {
            emailService.sendEmail(email);
        }

        System.out.println("Continue program execution");

        emailService.close();
    }

    private static void sendEmailsThroughMainThread(List<Email> emails) {
        EmailService emailService = new OneThreadEmailService();

        for (Email email : emails) {
            emailService.sendEmail(email);
        }

        System.out.println("Continue program execution");
    }

}
