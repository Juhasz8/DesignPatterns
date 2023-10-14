import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.Semaphore;

//implementing Closeable interface
public class Permit implements Closeable
{
    private Semaphore semaphore;

    public Permit(Semaphore semaphore)
    {
        this.semaphore = semaphore;
        //the acquire method could also be here, and then we wouldn't need to call it on initialization
    }

    @Override
    public void close() throws IOException
    {
        semaphore.release();
    }

    public Permit Acquire() throws InterruptedException
    {
        semaphore.acquire();
        return this;
    }


}
