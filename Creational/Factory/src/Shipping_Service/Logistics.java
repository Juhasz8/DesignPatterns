package Shipping_Service;

public abstract class Logistics
{

    public void FindTransport()
    {
        ITransport transport = CreateLogistics();
        transport.Deliver();
    }

    protected abstract ITransport CreateLogistics();

}
