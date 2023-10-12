package VirtualProxy;

public class Employee
{
    private String name;
    private double salary;

    public Employee(String name, double salary)
    {
        this.name = name;
        this.salary = salary;
    }

    public String GetName() { return name; }

    public double GetSalary() { return salary; }
}
