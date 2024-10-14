package module8.interfacetests.defaultsmethods;

public interface ThirdSubInterface extends SuperInterface {
    default void duplicatedMethod() {
        System.out.println("duplicatedMethod from ThirdSubInterface");
    }

}
