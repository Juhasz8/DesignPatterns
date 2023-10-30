/**

 Example of what kind of dependencies we want to solve with Dependency Injection:

 The problem:
 If we needed to change/replace classB with ClassC because ClassC has an optimized version of the Calculate() method,
 we need to recompile classA because we don't have a way to change that dependency, it's hardcoded inside of ClassA.

 */

public class DependentClassA
{

    //The creating of the object classB is hardcoded in classA
    private ClassB classB = new ClassB();

    //When a class classA uses any method of another class ClassB,
    //we can say that classB is a dependency of classA.
    public double TenPercent()
    {
        return (classB.Calculate() * 0.1d);
    }

}
