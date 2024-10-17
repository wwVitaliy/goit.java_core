package module8.homework;

public class Pentagon
        extends Shape {

    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private Point e;


    public Pentagon(Point a, Point b, Point c, Point d, Point e) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
    }

    public Point getA() {
        return a;
    }

    public Point getB() {
        return b;
    }

    public Point getC() {
        return c;
    }

    public Point getD() {
        return d;
    }

    public Point getE() {
        return e;
    }
}
