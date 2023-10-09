/**

 Singleton is a creational design pattern that lets you ensure that a class has only one instance, while providing a global access point to this instance.

 Singleton pattern lets you access some object from anywhere in the program. However, it also protects that instance from being overwritten by other code.

 All implementations of the Singleton have these two steps in common:
 Make the default constructor private, to prevent other objects from using the new operator with the Singleton class.
 Create a static creation method that acts as a constructor. Under the hood,this method calls the private constructor
 to create an object and saves it in a static field. All following calls to this method return the cached object.


 Use singletons carefully, as they violate the Single Responsibility Principle!

 https://refactoring.guru/design-patterns/singleton

 **/
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("---Singleton-Test:---");

        //this won't work because class constructor is private
        //Singleton mySingleton = new Singleton();

        //this won't work either because the instance is also private
        //Singleton.instance.AnyoneCanAccessMe();

        Singleton.getInstance().AnyoneCanAccessMe();
        System.out.println("------");

    }
}