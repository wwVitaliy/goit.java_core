package module8.numbertransformer;

public enum Digit {
    zero(0),
    one(1),
    two(2),
    three(3),
    four(4),
    five(5),
    six(6),
    sever(7),
    eight(8),
    nine(9);

    private int value;

    Digit (int value){
        this.value = value;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    public int getValue() {
        return this.value;
    }
}
