package Multiton_With_Factory;

public interface IMultitonFactory
{

    Multiton_F GetInstance(String identifier);

}
