package module8.interfacetests.defaultsmethods;

public interface SuperInterface {
    default void duplicatedMethod(){
        System.out.println("duplicatedMethod from SuperInterface");
    }

}
