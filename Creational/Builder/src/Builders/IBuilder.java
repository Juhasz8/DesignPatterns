package Builders;

public interface IBuilder
{
    void Reset();

    void BuildWalls();

    void BuildDoors(int num);

    void BuildWindows(int num);

    void BuildRoof();

}
