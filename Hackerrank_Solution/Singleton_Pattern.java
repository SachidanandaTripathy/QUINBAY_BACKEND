public class Singleton_Pattern {
    private Singleton_Pattern() {}
    public String str;
    private static Singleton_Pattern instance = null;
    public static Singleton_Pattern getSingleInstance() {
        if (instance == null) {
            instance = new Singleton_Pattern();
        }
        return instance;
    }
}
