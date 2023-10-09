package Box_Factory;

public class CrateCreator extends Creator
{

    //Factory method that creates the object
    @Override
    public ProductI CreateProduct()
    {
        return new CrateProduct();
    }
}
