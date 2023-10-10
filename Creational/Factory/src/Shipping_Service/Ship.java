package Shipping_Service;

//package protected class!
class Ship implements TransportI
{

    @Override
    public void Deliver()
    {
        System.out.println("Delivered by sea in a container.");
    }
}
