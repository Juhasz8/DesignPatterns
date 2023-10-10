package Builders;

public interface BuilderI
{
    void Reset();

    void BuildWalls();

    void BuildDoors(int num);

    void BuildWindows(int num);

    void BuildRoof();

}
