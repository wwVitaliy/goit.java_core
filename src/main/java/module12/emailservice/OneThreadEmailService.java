package module12.emailservice;

class OneThreadEmailService
        implements EmailService {

    @Override
    public void sendEmail(Email email) {
        //todo some vendor logic
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(email);
    }
}
