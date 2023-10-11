package Box_Factory;

public abstract class Creator
{

    public void SendPackage()
    {
        IProduct product = CreateProduct();
        System.out.println("Package sent!");
    }

    protected abstract IProduct CreateProduct();
}
