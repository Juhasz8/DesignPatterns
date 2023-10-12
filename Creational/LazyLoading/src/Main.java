import LazyInitialization.Car;
import LazyInitialization.CarType;
import VirtualProxy.*;

/**

 Lazy loading is the practice of delaying load or initialization of resources or objects
 until they're actually needed to improve performance and save system resources.

 Lazy loading is essential when the cost of object creation is very high and the use of the object is very rare.
 So this is the scenario where it’s worth implementing lazy loading.
 The fundamental idea of lazy loading is to load object/data when needed.

 There are 4 common implementations of the Lazy Loading pattern:
    1.Virtual proxy
    2.Lazy Initialization
    3.Ghost
    4.Value Holder

 About Lazy Loading
    https://www.imperva.com/learn/performance/lazy-loading/#:~:text=Lazy%20loading%20is%20the%20practice,performance%20and%20save%20system%20resources.
 Implementation from:
    https://www.geeksforgeeks.org/lazy-loading-design-pattern/

**/

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("---Lazy_Loading---");
        //VirtualProxy_Test
        System.out.println("VirtualProxy_Test: \n");

        Company company1 = new Company("Legit Company", "Via del Castro Laurenziano 7",  new ContactListProxy());

        //Client-side communicating through the interface:
        IContactList contactList = company1.GetContactList();
        for (Employee emp: contactList.GetEmployeeList())
        {
            System.out.println("Employee data::: name: " + emp.GetName() + " salary: " + emp.GetSalary());
        }

        //Lazy_Initialization_Test:
        System.out.println("\nLazy_Initialization_Test:\n");
        Car.GetCarByType(CarType.VOLVO);
        Car.PrintStoredCarTypes();

        Car.GetCarByType(CarType.BMW);
        Car.PrintStoredCarTypes();

        Car.GetCarByType(CarType.VOLVO);
        Car.PrintStoredCarTypes();
        System.out.println("------");
        
    }
}