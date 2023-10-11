import Multiton_Basic.Multiton_B;
import Multiton_With_Factory.MultitonFactory;
import Multiton_With_Factory.Multiton_F;

/**
 The multiton pattern is a creational design pattern that allows you to create
 a fixed number of instances of a class, with each instance having a unique identifier.
 The multiton pattern is similar to the singleton pattern,
 but it allows you to create multiple instances instead of just one.

 The main purpose of using the multiton pattern is to ensure that you have a limited number of instances of a class,
 and that each instance has a unique identifier. This can be useful in situations where you need to manage
 a fixed number of resources,such as database connections or network sockets.

 By using the multiton pattern, you can ensure that you have a consistent and well-defined way of accessing these resources,
 and you can avoid the overhead of creating unnecessary instances of the class.

 The Multiton pattern can also be used with
    Factory pattern
    Lazy Loading pattern

 In C#, you can also implement the multiton using a static constructor
    A static constructor is used to initialize any static data,
    or to perform a particular action that needs to be performed only once.
    It is called automatically before the first instance is created or any static members are referenced.
 In Java, constructors are not allowed to be static

 You can find these different implementations of the multiton pattern: (C#)
 https://justgokus.medium.com/what-is-the-multiton-design-pattern-eeeb5dd8bc7d#:~:text=The%20multiton%20pattern%20is%20a%20creational%20design%20pattern%20that%20allows,instances%20instead%20of%20just%20one.

**/

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("---Multiton Test:---");

        //this will cause the multiton class to create a multiton object and store it, then it will print its name
        Multiton_B testMultiton = Multiton_B.GetInstance("firstMultiton");
        //this will return the already existing multiton and print its identifier
        System.out.println("My ID: " + Multiton_B.GetInstance("firstMultiton").GetIdentifier());


        //this will cause the multiton class to create a multiton object and store it, then it will print its name
        System.out.println("My ID: " + Multiton_B.GetInstance("secondMultiTest").GetIdentifier());

        System.out.println("Stored instances count: "+ Multiton_B.GetStoredMultitonCount());
        System.out.println("------");
        System.out.println("\n ---Multiton-Factory Test:---");

        //creating a multiton factory
        MultitonFactory multitonFactory = new MultitonFactory();
        //making 3 objects with the factory: A,B,C
        Multiton_F factory_Made_A = multitonFactory.GetInstance("Multiton_A");
        System.out.println("Factory-Made: ID: " + factory_Made_A.GetIdentifier() + " Data: " + factory_Made_A.GetData());

        Multiton_F factory_Made_B = multitonFactory.GetInstance("Multiton_B");
        System.out.println("Factory-Made: ID: " + factory_Made_B.GetIdentifier() + " Data: " + factory_Made_B.GetData());

        Multiton_F factory_Made_C = multitonFactory.GetInstance("Multiton_C");
        System.out.println("Factory-Made: ID: " + factory_Made_C.GetIdentifier() + " Data: " + factory_Made_C.GetData());

        //printing the amount of objects the factory has made so far
        System.out.println("There are " + MultitonFactory.GetStoredMultitonCount() + " factory made objects. ");

        System.out.println("------");


    }
}