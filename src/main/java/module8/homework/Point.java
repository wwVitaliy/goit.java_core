package module8.homework;

public class Point
        implements Drawable, Fillable {
    private int x;
    private int y;
    private Color fillColor;

    public String getName() {
        return "(" + x + ", " + y + ")";
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.println(getName() + " was drew");
    }

    @Override
    public Color getFillColor() {
        return this.fillColor;
    }

    @Override
    public void fill(Color color) {
        this.fillColor = color;
    }

    @Override
    public String toString() {
        return "("
                + x
                + ", "
                + y
                + ')';
    }
}
