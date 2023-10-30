/**

 An improved version of the DependentClassA, but Setter Injection is still not recommended

 With this approach, we remove the new keyword from our classA.
 Thus, we move the responsibility for the creation of classB away from classA.
 But classA still has a hard dependency on classB but now it can be injected from the outside:

 The problem:
 If we needed to change/replace classB with ClassC because ClassC has an optimized version of the Calculate() method,
 we need to recompile classA because we don't have a way to change that dependency, it's hardcoded inside of ClassA.

 */

public class SetterI_ClassA
{

    private ClassB classB;

    //The creating of the object classB is not hardcoded anymore in classA
    public void SetClassB(ClassB injected)
    {
        classB = injected;
    }

    public double TenPercent()
    {
        return (classB.Calculate() * 0.1d);
    }


}
