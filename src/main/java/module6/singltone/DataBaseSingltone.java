package module6.singltone;

public class DataBaseSingltone {
    //Private static instance.
    private static final DataBaseSingltone INSTANCE = new DataBaseSingltone();

    //Private constructor
    private DataBaseSingltone(){
    };

    // Public method to get instance
    public static DataBaseSingltone getInstance(){
        return INSTANCE;
    }
}
