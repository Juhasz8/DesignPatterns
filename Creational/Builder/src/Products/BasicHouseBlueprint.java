package Products;

public class BasicHouseBlueprint
{
    private final int numWalls;
    private final int numDoors;
    private final int numWindows;
    private final boolean hasRoof;

    public BasicHouseBlueprint(int numWalls, int numDoors, int numWindows, boolean hasRoof)
    {
        this.numWalls = numWalls;
        this.numDoors = numDoors;
        this.numWindows = numWindows;
        this.hasRoof = hasRoof;
    }

    public int GetNumWalls()
    {
        return numWalls;
    }

    public int GetNumDoors()
    {
        return numDoors;
    }

    public int GetNumWindows()
    {
        return numWindows;
    }

    public boolean HasRoof()
    {
        return hasRoof;
    }

    //overwriting toString just for debugging/showcase purposes
    @Override
    public String toString()
    {
        String info = "The blueprint contains: \n";
        info += "Number of walls: " + numWalls + "\n";
        info += "Number of doors: " + numDoors + "\n";
        info += "Number of windows: " + numWindows + "\n";
        info += hasRoof ? "And a roof" : "And no roof :( ";
        return info;
    }
}
