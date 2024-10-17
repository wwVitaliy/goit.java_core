package module8.homework;

public abstract class Shape
        implements Drawable, Fillable, Borderalble {

    private String name = "";
    private Color fillColor = new Color(0, 0, 0);
    private Color borderColor = new Color(0, 0, 0);

    public String getName() {
        return name.isEmpty() ? "unnamed" : this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Color getFillColor() {
        return fillColor;
    }

    public void setFillColor(Color fillColor) {
        this.fillColor = fillColor;
    }

    @Override
    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    @Override
    public void draw() {
        System.out.println(this.getName() + " is drew");
    }

    public void printName(ShapePrinter printer) {
        printer.print(this);
    }

    @Override
    public void fill(Color color) {
        this.fillColor = color;
    }

    @Override
    public void addBorder(Color color) {
        this.borderColor = color;
    }
}
