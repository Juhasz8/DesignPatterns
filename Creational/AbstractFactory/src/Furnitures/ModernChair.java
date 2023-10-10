package Furnitures;

//not a public class!
class ModernChair implements ChairI
{

    @Override
    public void HasLegs()
    {
        System.out.println("This modern chair has 3 legs.");
    }

    @Override
    public void SitOn()
    {
        System.out.println("You sat on this modern chair.");
    }
}
