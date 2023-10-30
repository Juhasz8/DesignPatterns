/**

 An improved version of the SetterI_ClassA, this version is the recommended one.

 With this approach, we remove the new keyword from our classA.
 Thus, we move the responsibility for the creation of classB away from classA.
 But classA still has a hard dependency on classB but now it can be injected from the outside:

 The problem:
 If we needed to change/replace classB with ClassC because ClassC has an optimized version of the Calculate() method,
 we need to recompile classA because we don't have a way to change that dependency, it's hardcoded inside of ClassA.

 */

public class ConstI_ClassA
{
    private ClassB classB;

    //classA still has a hard dependency on classB but now it can be injected from the outside using the constructor:
    public ConstI_ClassA(ClassB injected)
    {
        classB = injected;
    }

    public double TenPercent()
    {
        return (classB.Calculate() * 0.1d);
    }

}
