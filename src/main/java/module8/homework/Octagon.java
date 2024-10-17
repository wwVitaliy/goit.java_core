package module8.homework;

public class Octagon
        extends Shape{

    private Point a;
    private Point b;
    private Point c;
    private Point d;
    private Point e;
    private Point f;

    public Octagon(Point a, Point b, Point c, Point d, Point e, Point f) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
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

    public Point getF() {
        return f;
    }

    @Override
    public String toString() {
        return "Octagon{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                ", d=" + d +
                ", e=" + e +
                ", f=" + f +
                '}';
    }
}
