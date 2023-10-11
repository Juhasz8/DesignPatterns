package Box_Factory;

//package protected class!
class BoxProduct implements IProduct
{
    public BoxProduct()
    {
        onCreation();
    }

    @Override
    public void onCreation()
    {
        System.out.println("BoxProduct Created");
    }
}
