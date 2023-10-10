package Products;

public class BasicHouse
{

    private final int numWalls;
    private final int numDoors;
    private final int numWindows;
    private final boolean hasRoof;

    public BasicHouse(int numWalls, int numDoors, int numWindows, boolean hasRoof)
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
        return "I am a house with: " + numWalls + " walls, " + numDoors + " doors, " + numWindows + " windows, " + " roof? " + hasRoof;
    }
}
