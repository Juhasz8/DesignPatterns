package Furnitures;

//not a public class!
class VictorianChair implements ChairI
{

    @Override
    public void HasLegs()
    {
        System.out.println("This victorian chair has 4 legs.");
    }

    @Override
    public void SitOn()
    {
        System.out.println("You sat on this victorian chair.");
    }
}
