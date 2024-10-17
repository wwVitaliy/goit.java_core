package module8.homework;

public class Color {
    private int red;
    private int blue;
    private int green;

    public void setRed(int red) {
        this.red = red;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getRed() {
        return red;
    }

    public int getBlue() {
        return blue;
    }

    public int getGreen() {
        return green;
    }

    public Color(int red, int blue, int green) {
        this.red = red;
        this.blue = blue;
        this.green = green;
    }
}
