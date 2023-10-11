package Builders;

import Products.BasicHouse;

public class BasicHouseBuilder implements IBuilder
{
    private BasicHouse result;

    private int numWalls = 0;
    private int numDoors = 0;
    private int numWindows = 0;
    private boolean hasRoof = false;

    @Override
    public void Reset()
    {
        numWalls = 0;
        numDoors = 0;
        numWindows = 0;
        hasRoof = false;
    }

    @Override
    public void BuildWalls()
    {
        this.numWalls = 4;
    }

    @Override
    public void BuildDoors(int num)
    {
        this.numDoors = num;
    }

    @Override
    public void BuildWindows(int num)
    {
        this.numWindows = num;
    }

    @Override
    public void BuildRoof()
    {
        this.hasRoof = true;
    }


    // Concrete builders are supposed to provide their own
    // methods for retrieving results. That's because various
    // types of builders may create entirely different products
    // that don't all follow the same interface. Therefore such
    // methods can't be declared in the builder interface (at
    // least not in a statically-typed programming language).

    public BasicHouse GetResult()
    {
        result = new BasicHouse(numWalls, numDoors, numWindows, hasRoof);
        Reset();
        return result;
    }
}
