package VirtualProxy;

import java.util.ArrayList;

public class ContactList implements IContactList
{

    @Override
    public ArrayList<Employee> GetEmployeeList()
    {
        return GetEmployeeListFromDataBase();
    }
/*
    There could be thousands of employees in a company.
    Loading the Company object from the database along with the list of all its employees in the ContactList object could be very time consuming.
    In some cases you don’t even require the list of the employees,
    but you are forced to wait until the company and its list of employees loaded into the memory.
*/
    private static ArrayList<Employee> GetEmployeeListFromDataBase()
    {
        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Bob", 3056.24));
        employees.add(new Employee("Alberta", 2786.52));
        employees.add(new Employee("Diana", 5231.6));
        employees.add(new Employee("Patroclus", 9037.79));

        return employees;
    }
}
