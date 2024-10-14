package module8.interfacetests;

public interface Drivable extends Transport {
  default void drive(){
     System.out.println("default driving");
  };
}

