package Furnitures;

public class ModernFurnitureFactory implements FurnitureFactoryI
{

    @Override
    public ChairI CreateChair()
    {
        return new ModernChair();
    }

    @Override
    public CoffeeTableI CreateCoffeeTable()
    {
        return new ModernCoffeeTable();
    }

    @Override
    public SofaI CreateSofa()
    {
        return new ModernSofa();
    }
}
