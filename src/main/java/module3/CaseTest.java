package module3;

public class CaseTest {
    public static void main(String[] args) {
        String today = "Mon";

        switch (today){
            case "Mon", "Tue", "Wed", "Thi", "Fri" -> System.out.println("working day");
            case "Sat", "Sun" -> System.out.println("Weekend");
            default -> System.out.println("Wrong text");
        }
    }
}
