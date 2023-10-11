import Box_Factory.*;
import Shipping_Service.*;

/**

 Factory Method is a creational design pattern that provides an interface for creating objects in a superclass,
 but allows subclasses to alter the type of objects that will be created.

 Use the Factory Method when you don’t know beforehand the exact types and dependencies of the objects your code should work with.

 The Factory Method separates product construction code from the code that actually uses the product.
 Therefore it’s easier to extend the product construction code independently from the rest of the code.

 For example, to add a new product type to the app, you’ll only need to create a new creator subclass and override the factory method in it.


 Example 1: Box_Factory:
 Products: BoxProduct, CrateProduct

 Example 2: Shipping_Service:
 Products: Ship, Truck


 Also known as: Virtual Constructor

 https://refactoring.guru/design-patterns/factory-method
 **/

public class Main
{
    public static void main(String[] args)
    {

        System.out.println("---Box_Factory---!");
        BoxCreator boxCreator = new BoxCreator();
        boxCreator.SendPackage();

        CrateCreator crateCreator = new CrateCreator();
        IProduct Product2 = crateCreator.CreateProduct();
        System.out.println("------");

        System.out.println("---Shipping_Service!---");
        RoadLogistics roadLogistics = new RoadLogistics();
        roadLogistics.CreateLogistics().Deliver();

        SeaLogistics seaLogistics = new SeaLogistics();
        seaLogistics.FindTransport();
        System.out.println("------");
    }
}