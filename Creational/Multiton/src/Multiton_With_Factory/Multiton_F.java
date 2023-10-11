package Multiton_With_Factory;

import java.util.HashMap;

public class Multiton_F
{
    //doesn't necessarily need to be final, depends on whether we could potentially want to change it or not
    private final String identifier;
    private final int data;

    public Multiton_F(String identifier, int data)
    {
        this.identifier = identifier;
        this.data = data;
    }

    //Getter for the identifier
    public String GetIdentifier()
    {
        return identifier;
    }

    //Getter for the data
    public int GetData()
    {
        return data;
    }

}
