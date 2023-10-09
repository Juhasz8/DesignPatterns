package Box_Factory;

public abstract class Creator
{

    public void SendPackage()
    {
        ProductI product = CreateProduct();
        System.out.println("Package sent!");
    }

    protected abstract ProductI CreateProduct();
}
