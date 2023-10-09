package Shipping_Service;

public abstract class Logistics
{

    public void FindTransport()
    {
        TransportI transport = CreateLogistics();
        transport.Deliver();
    }

    protected abstract TransportI CreateLogistics();

}
