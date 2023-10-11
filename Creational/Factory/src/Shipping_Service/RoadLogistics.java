package Shipping_Service;

public class RoadLogistics extends Logistics
{


    //Factory method that creates the object
    @Override
    public ITransport CreateLogistics()
    {
        return new Truck();
    }
}
