package module8.interfacetests.defaultsmethods;

public interface FirstSubInterface extends SuperInterface {
    default void duplicatedMethod() {
        System.out.println("duplicatedMethod from FirstSubInterface");
    }

}
