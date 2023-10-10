import Builders.BuilderI;
import Types.BasicHouseTypes;

;

public class Director
{

    //instead of having one method with enum type parameters,
    //we could also have multiple methods for the different types
    public void BuildHouseOrBlueprint(BuilderI builder, BasicHouseTypes houseType)
    {
        switch (houseType)
        {
            case ONLY_WALLS:
            {
                builder.BuildWalls();
                break;
            }
            case SIMPLE:
            {
                builder.BuildWalls();
                builder.BuildDoors(1);
                builder.BuildWindows(2);
                break;
            }
            case HUGE:
            {
                builder.BuildWalls();
                builder.BuildDoors(4);
                builder.BuildWindows(12);
                builder.BuildRoof();
                break;
            }
        }
    }

    //instead of making fancyHouse a type of BasicHouseType:
    public void BuildFancyHouse(BuilderI builder)
    {
        builder.BuildWalls();
        builder.BuildDoors(6);
        builder.BuildWindows(25);
        builder.BuildRoof();
    }

}
