import java.util.concurrent.Semaphore;

/*
Pay attention to the try block and to the Closeable interface that the class Permit now implements.
The object p will be “closed” when the try block exits. It may exit either at the end, or by the return or throw statements.
In either case Permit.close() will be called: this is how try-with-resources works in Java.
*/

public class Counter implements Runnable
{
    private Semaphore sem;

    private int numToPrint = 0;
    private int countTo = 0;

    public Counter(int countTo, int permits)
    {
        this.countTo = countTo;
        sem = new Semaphore(permits);
    }

    public void Print() throws Exception
    {
        //pay attention to syntax!
        //using a try-with-resources statement!

        //if a thread cant enter the "try" its waiting here

        //We acquire the permit on initializing the object p from class Permit
        //-> hence the name: Resource Acquisition In Initialization  (the acquire method could also be in the constructor of Permit instead of called here)
        try (Permit p = new Permit(this.sem).Acquire())
        {
            System.out.println("Available permits after entering: " + sem.availablePermits());

            while (numToPrint < countTo)
            {
                //semaphore is being released even if an exception is thrown
                if (numToPrint > 10000)
                    throw new Exception("X is too large!");

                numToPrint++;
                System.out.println("x = " + numToPrint);
            }
        }
        //semaphore is being released here, whenever the try statement is left by the thread
        System.out.println("Try statement over");
    }


    @Override
    public void run()
    {
        try
        {
            Print();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}
