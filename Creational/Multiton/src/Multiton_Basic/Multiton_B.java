package Multiton_Basic;

import java.util.HashMap;

public class Multiton_B
{
    //using hashmap because dictionary is obsolete!
    private static HashMap<String, Multiton_B> instances = new HashMap<String, Multiton_B>();

    //doesn't necessarily need to be final, depends on whether we could potentially want to change it or not
    private final String identifier;

    //Private constructor so no multiton can be created outside the multiton class!
    private Multiton_B(String identifier)
    {
        this.identifier = identifier;
    }

    //if a multiton with the asked identifier already exists, we just return it,
    //otherwise we create it first and store it, and then return it.
    public static Multiton_B GetInstance(String identifier)
    {
        //in a multithreaded environment the thread should acquire lock on the factory when entering this method

        if(!instances.containsKey(identifier))
        {
            instances.put(identifier, new Multiton_B(identifier));
        }

        return instances.get(identifier);
    }

    //Getter for the identifier
    public String GetIdentifier()
    {
        return identifier;
    }

    //Getter for the length of the instances Hashmap
    public static int GetStoredMultitonCount()
    {
        return instances.size();
    }
}
