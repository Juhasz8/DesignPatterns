import Builders.BasicHouseBlueprintBuilder;
import Builders.BasicHouseBuilder;
import Products.BasicHouse;
import Products.BasicHouseBlueprint;
import Types.BasicHouseTypes;

/**

 Builder is a creational design pattern that lets you construct complex objects step by step.
 The pattern allows you to produce different types and representations of an object using the same construction code.

 Imagine a complex object that requires laborious, step-by-step initialization of many fields and nested objects.
 Such initialization code is usually buried inside a monstrous constructor with lots of parameters.#
 Or even worse: scattered all over the client code.

 The Builder pattern suggests that you extract the object construction code out of its own class and move it to separate objects called builders.

 Unlike other creational patterns, builder lets you construct products that don't follow the common interface.

 https://refactoring.guru/design-patterns/builder

**/

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("---Builder---");
        //creating the director
        Director director = new Director();

        //creating the builder objects
        //we could create more of the same type if preferred
        BasicHouseBuilder houseBuilder = new BasicHouseBuilder();
        BasicHouseBlueprintBuilder blueprintBuilder = new BasicHouseBlueprintBuilder();

        //making the house builder build a simple house
        director.BuildHouseOrBlueprint(houseBuilder, BasicHouseTypes.SIMPLE);

        //store the first house built
        BasicHouse simpleHouse = houseBuilder.GetResult();
        System.out.println("Simple house: " + simpleHouse.toString());
        System.out.println("---");

        //now tell the director to use the same houseBuilder but to build a different house
        director.BuildHouseOrBlueprint(houseBuilder, BasicHouseTypes.HUGE);

        //store the second house built
        BasicHouse hugeHouse = houseBuilder.GetResult();
        System.out.println("Huge house: " + hugeHouse.toString());
        System.out.println("---");

        //now tell the director to use the blueprint builder to build a house blueprint for a huge house
        director.BuildHouseOrBlueprint(blueprintBuilder, BasicHouseTypes.HUGE);
        //store the blueprint for the huge house
        BasicHouseBlueprint hugeHouseBlueprint = blueprintBuilder.GetResult();
        System.out.println("Blueprint for the huge house: " + hugeHouseBlueprint.toString());

        System.out.println("------");

    }
}