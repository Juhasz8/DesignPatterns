package Box_Factory;

public class CrateCreator extends Creator
{

    //Factory method that creates the object
    @Override
    public IProduct CreateProduct()
    {
        return new CrateProduct();
    }
}
