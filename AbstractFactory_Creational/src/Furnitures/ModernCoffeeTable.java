package Furnitures;

//not a public class!
class ModernCoffeeTable implements CoffeeTableI
{

    @Override
    public void PutGlass()
    {
        System.out.println("You put your glass on this modern coffee table.");
    }
}
