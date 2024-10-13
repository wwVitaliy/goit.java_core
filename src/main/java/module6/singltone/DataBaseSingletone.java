package module6.singltone;

public class DataBaseSingletone {
    //Private static instance.
    private static final DataBaseSingletone INSTANCE = new DataBaseSingletone();

    //Private constructor
    private DataBaseSingletone(){
    };

    // Public method to get instance
    public static DataBaseSingletone getInstance(){
        return INSTANCE;
    }
}
