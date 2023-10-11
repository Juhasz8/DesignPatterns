package Furnitures;

public class VictorianFurnitureFactory implements IFurnitureFactory
{

    @Override
    public IChair CreateChair()
    {
        return new VictorianChair();
    }

    @Override
    public ICoffeeTable CreateCoffeeTable()
    {
        return new VictorianCoffeeTable();
    }

    @Override
    public ISofa CreateSofa()
    {
        return new VictorianSofa();
    }
}
