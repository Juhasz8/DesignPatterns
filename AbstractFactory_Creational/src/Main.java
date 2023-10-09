import Furnitures.*;

/**

 Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.

 Examples:
 Furnitures:
 Family of products: Victorian, Modern
 Products: Chair, CoffeeTable, Sofa

 After creation of the factory abstract object, the client can only create objects through this factory,
 and they will all belong to the same family, without the client specifying anything.
 The client can only communicate with the instantiated objects through the abstract interfaces.

 https://refactoring.guru/design-patterns/abstract-factory

**/
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("---Furnitures:---");
        FurnitureFactoryI furnitureFactory = new VictorianFurnitureFactory();
        //FurnitureFactoryI furnitureFactory = new ModernFurnitureFactory();

        ChairI myChair = furnitureFactory.CreateChair();
        CoffeeTableI myTable = furnitureFactory.CreateCoffeeTable();
        SofaI mySofa = furnitureFactory.CreateSofa();

        myChair.SitOn();
        myTable.PutGlass();
        mySofa.SitOn();
        System.out.println("------");


    }
}