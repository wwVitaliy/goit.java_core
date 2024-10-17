package module8.homework;

public class Point
        implements Nameble {
    private int x;
    private int y;

    @Override
    public String getName() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public void printName() {
        //todo
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
