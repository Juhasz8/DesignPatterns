public class Singleton
{
    //make the instance private so the only way to access it is through the getInstance method
    private static Singleton instance;

    //make base constructor private to make sure that an object of this type
    //cannot be created the regular way
    private Singleton()
    {

    }

    //public static method for getting the one and only instance of this class
    //calling this method is the only way to get the singleton instance object
    public static Singleton getInstance()
    {
        if(instance == null)
            instance = new Singleton();

        return instance;
    }

    public void AnyoneCanAccessMe()
    {
        System.out.println("Singleton class method reached");
    }

}
