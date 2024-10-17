package module8.homework;

public class GraphicEditorTest {

    public static void main(String[] args) {
        Circle myCircle = new Circle(new Point(1, 1), 10);

        Triangle myTriangle = new Triangle(
                new Point(2, 5),
                new Point(6, 18),
                new Point(7, 24)
        );

        Rectangle myRectangle = new Rectangle(
                new Point(10, 10),
                new Point(10, 15),
                new Point(5, 6),
                new Point(0, 13)
        );

        Pentagon myPentagon = new Pentagon(
                new Point(5,7),
                new Point(9,8),
                new Point(1,2),
                new Point(6,7),
                new Point(9,15)
        );

        Octagon myOctagon = new Octagon(
                new Point(2,6),
                new Point(8,6),
                new Point(5,7),
                new Point(16,7),
                new Point(6,3),
                new Point(7,9)
        );

        ShapePrinter myPrinter = new ConsoleShapePrinter();
        myTriangle.printName(myPrinter);
        myCircle.setName("coolCircle");
        myCircle.printName(myPrinter);

        
    }
}
