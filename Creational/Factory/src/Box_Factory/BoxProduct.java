package Box_Factory;

//package protected class!
class BoxProduct implements ProductI
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
