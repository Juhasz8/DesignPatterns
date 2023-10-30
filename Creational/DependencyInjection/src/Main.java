/**

 Dependency Injection is a programming technique in which an object or function receives
 other objects or functions that it requires, as opposed to creating them internally.

 The pattern ensures that an object or function which wants to use a given service should not have to know how to construct those services.


 Dependency injection makes implicit dependencies explicit and helps solve the following problems:
     How can a class be independent from the creation of the objects it depends on?
     How can an application, and the objects it uses support different configurations?
     How can the behavior of a piece of code be changed without editing it directly?


 About DI:
    https://en.wikipedia.org/wiki/Dependency_injection
    https://medium.com/groupon-eng/dependency-injection-in-java-9e9438aa55ae
    https://www.digitalocean.com/community/tutorials/java-dependency-injection-design-pattern-example-tutorial
 */

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("---Dependency_Injection---");

        //Without Dependency Injection:
        DependentClassA classA = new DependentClassA();
        System.out.println("Calculating ten percent 1: " + classA.TenPercent());
        System.out.println("---");

        //We are hiding the ClassB dependency in ClassA because by reading the constructor signature,
        //we cannot identify its dependencies right away.
        SetterI_ClassA setterClassA = new SetterI_ClassA();

        //The code below causes a NullPointerException on runtime:
        //System.out.println("Calculating ten percent: " + setterClassA.TenPercent());

        //The above example is better than the initial approach because now we can inject
        //in classA an instance of ClassB or even better, a subclass of ClassB:
        setterClassA.SetClassB(new ClassB());
        System.out.println("Calculating ten percent 2: " + setterClassA.TenPercent());
        System.out.println("---");

        //We are showing our dependency:
        ConstI_ClassA constClassA = new ConstI_ClassA(new ClassB());
        System.out.println("Calculating ten percent 3: " + constClassA.TenPercent());

        System.out.println("------");
    }
}