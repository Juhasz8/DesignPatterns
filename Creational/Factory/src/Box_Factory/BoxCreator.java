package Box_Factory;

public class BoxCreator extends Creator
{

    //Factory method that creates the object
    @Override
    public ProductI CreateProduct()
    {
        return new BoxProduct();
    }
}
