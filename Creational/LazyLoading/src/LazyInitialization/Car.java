package LazyInitialization;

import java.util.HashMap;

public class Car
{
    private static HashMap<CarType, Car> carTypesMap = new HashMap<>();

    private CarType myType;

    //Private constructor
    private Car(CarType type)
    {
        myType = type;
    }

    public static Car GetCarByType(CarType type)
    {
        if(!carTypesMap.containsKey(type))
            carTypesMap.put(type, new Car(type));

        return carTypesMap.get(type);
    }

    public static Car GetCarByTypeConcurrentVersion(CarType type)
    {
        if(!carTypesMap.containsKey(type))
        {
            synchronized (carTypesMap)
            {
                // Check again, after having acquired the lock to make sure
                // the instance was not created meanwhile by another thread
                if(!carTypesMap.containsKey(type))
                {
                    // Lazy initialization
                    carTypesMap.put(type, new Car(type));
                }
            }
        }
        return carTypesMap.get(type);
    }

    public static void PrintStoredCarTypes()
    {
        if(carTypesMap.size() == 0)
            return;

        System.out.println("Number of CarTypes stored: " + carTypesMap.size());

        //foreach for <KeyValuePair> // looping through the carTypesMap
        for (HashMap.Entry<CarType, Car> entry : carTypesMap.entrySet())
        {
            System.out.println("Stored Car Type: " + entry.getKey().toString());
        }

        //just for nicer console log
        System.out.println();
    }

}
