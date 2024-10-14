package module8.interfacetests.defaultsmethods;

public class SubClass3
        implements FirstSubInterface, ThirdSubInterface
{

    @Override
    public void duplicatedMethod() {
        System.out.println("duplicatedMethod from SubClass3");
    }
}
