package module8.interfacetests;

public class Car implements Drivable{


//    @Override
//    public void drive() {
//        System.out.println("driving");
//    }

    @Override
    public void speedUp() {
        System.out.println("speed++");
    }

    @Override
    public void brake() {
        System.out.println("speed--");
    }
}
