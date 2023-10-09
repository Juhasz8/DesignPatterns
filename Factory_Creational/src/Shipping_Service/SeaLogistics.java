package Shipping_Service;

public class SeaLogistics extends Logistics
{


    //Factory method that creates the object
    @Override
    protected TransportI CreateLogistics()
    {
        return new Ship();
    }
}
