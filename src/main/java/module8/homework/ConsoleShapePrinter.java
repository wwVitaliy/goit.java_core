package module8.homework;

public class ConsoleShapePrinter
        implements ShapePrinter {
    @Override
    public void print(Shape shape) {
        System.out.println(shape.getName());
    }
}
