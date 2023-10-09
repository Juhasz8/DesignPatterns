package Shipping_Service;

public class RoadLogistics extends Logistics
{


    //Factory method that creates the object
    @Override
    public TransportI CreateLogistics()
    {
        return new Truck();
    }
}
