package Shipping_Service;

//package protected class!
class Truck implements TransportI
{

    @Override
    public void Deliver()
    {
        System.out.println("Delivered by land in a box.");
    }
}
