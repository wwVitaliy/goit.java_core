package module12.emailservice;

record Email(String text, String sendTo) {
    @Override
    public String toString() {
        return "Email [" + this.text + "] send to [" + this.sendTo + "]";
    }
}
