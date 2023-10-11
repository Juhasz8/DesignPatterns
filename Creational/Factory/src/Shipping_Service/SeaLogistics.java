package Shipping_Service;

public class SeaLogistics extends Logistics
{


    //Factory method that creates the object
    @Override
    protected ITransport CreateLogistics()
    {
        return new Ship();
    }
}
