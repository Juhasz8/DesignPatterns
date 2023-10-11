package Multiton_With_Factory;

import java.util.HashMap;

public class MultitonFactory implements IMultitonFactory
{
    //using hashmap because dictionary is obsolete!
    private static HashMap<String, Multiton_F> instances = new HashMap<String, Multiton_F>();

    @Override
    public Multiton_F GetInstance(String identifier)
    {
        //in a multithreaded environment the thread should acquire lock on the factory when entering this method

        if(!instances.containsKey(identifier))
        {
            //Load the instance's details from a database or some other source
            //For the purpose of the test I just store its index in the instances map
            int value = instances.size();
            instances.put(identifier, new Multiton_F(identifier, value));
        }

        return instances.get(identifier);
    }

    public static int GetStoredMultitonCount()
    {
        return instances.size();
    }
}
