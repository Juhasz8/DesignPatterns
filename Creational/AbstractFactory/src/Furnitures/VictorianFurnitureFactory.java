package Furnitures;

public class VictorianFurnitureFactory implements FurnitureFactoryI
{

    @Override
    public ChairI CreateChair()
    {
        return new VictorianChair();
    }

    @Override
    public CoffeeTableI CreateCoffeeTable()
    {
        return new VictorianCoffeeTable();
    }

    @Override
    public SofaI CreateSofa()
    {
        return new VictorianSofa();
    }
}
