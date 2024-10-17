package module8.homework;

public abstract class Shape
    implements Nameble{

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void printName() {
        ConsoleShapePrinter printer = new ConsoleShapePrinter();
        printer.print(this);
    }
}
