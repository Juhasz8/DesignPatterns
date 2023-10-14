import static java.lang.Thread.*;

/**

 Resource Acquisition Is Initialization (RAII)
 is a design idea introduced in C++ by Bjarne Stroustrup for exception-safe resource management.
 Thanks to garbage collection Java doesn’t have this feature, but we can implement something similar, using try-with-resources.

 RAII is associated most prominently with C++, where it originated, but also Ada, Vala, and Rust.

 The RAII design is often used for controlling mutex locks in multi-threaded applications.
 In that use, the object releases the lock when destroyed. Without RAII in this scenario the potential
 for deadlock would be high and the logic to lock the mutex would be far from the logic to unlock it.
 With RAII, the code that locks the mutex essentially includes the logic that the lock will be released when execution leaves the scope of the RAII object.


 Sources:
 https://en.wikipedia.org/wiki/Resource_acquisition_is_initialization

 https://www.geeksforgeeks.org/resource-acquisition-is-initialization/

 RAII In Java:
 https://www.yegor256.com/2017/08/08/raii-in-java.html

 About Semaphore:
 https://en.wikipedia.org/wiki/Semaphore_(programming)
 https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Semaphore.html

 Try-with-resources statement:
 https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html


 Conclusion:
 In supported languages, RAII is a powerful tool to abstract resources without manually managing them.
 It prevents leaks and nasty bugs. Developers should use it to make their life easier.

 **/

public class Main
{
    public static void main(String[] args) throws InterruptedException
    {
        System.out.println("---RAII---");
        System.out.println("---Test1:---");
        //sleep just for proper test-case printing reasons
        sleep(100);

        //Remark: Keep in mind, that RAII does NOT ensure thread safety / synchronization.
        //Only if we limit the number of permits to 1, as you see in the example below,
        //the numbers from 1 to 10 are being written in correct ascending order.
        //The reason for this is that only one thread will be allowed to actually run the counting method.
        //the others will be waiting to enter, then when that 1 thread finished the counting, exists, releases the semaphore.
        //After this the others will proceed to enter then exit immediately from the counting method because they realize they don't need to count anymore.
        //This is what you see after the numbers are printed.
        Counter testCounter1 = new Counter(10, 1);
        //Creating 5 threads to try to run the counter
        for (int i = 0; i < 5; i++)
        {
            Thread myThread = new Thread(testCounter1);
            myThread.start();
        }

        //sleep just for proper test-case printing reasons
        sleep(100);

        System.out.println("\n---Test2:---");
        //In the second case the number of permits is larger than 1, which means the numbers will NOT be ordered, since there is no synchronization.
        //The point here is still to restrict the number of threads allowed to enter and run the counting method, in this case we are limiting it to 3.
        Counter testCounter2 = new Counter(25, 3);
        //Creating 10 threads to try to run the counter
        for (int i = 0; i < 10; i++)
        {
            Thread myThread = new Thread(testCounter2);
            myThread.start();
        }

        //sleep just for proper test-case printing reasons
        sleep(100);

        System.out.println("------");

    }
}