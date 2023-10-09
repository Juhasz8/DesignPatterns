package Box_Factory;

//package protected class!
class CrateProduct implements ProductI
{
    public CrateProduct()
    {
        onCreation();
    }

    @Override
    public void onCreation()
    {
        System.out.println("CrateProduct created");
    }
}
