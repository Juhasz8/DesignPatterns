import java.util.Enumeration;
import java.util.Hashtable;

public abstract class ObjectPool<T>
{

    private long deadTime;

    private Hashtable<T, Long> lock, unlock;

    protected ObjectPool()
    {
        deadTime = 50000; //50 seconds
        lock = new Hashtable<T, Long>();
        unlock = new Hashtable<T, Long>();
    }

    protected abstract T create();

    protected abstract void dead(T o);

    protected abstract boolean validate(T o);

    public synchronized T TakeOut()
    {
        long now = System.currentTimeMillis();
        T t;
        if(unlock.size() > 0)
        {
            Enumeration<T> e = unlock.keys();
            while (e.hasMoreElements())
            {
                t = e.nextElement();
                if((now - unlock.get(t)) > deadTime)
                {
                    // object has died
                    unlock.remove(t);
                    dead(t);
                    t = null;
                }
                else
                {
                    if(validate(t))
                    {
                        unlock.remove(t);
                        lock.put(t, now);
                        return t;
                    }
                    else
                    {
                        //object failed validation
                        unlock.remove(t);
                        dead(t);
                        t = null;
                    }
                }
            }
        }
        // no objects available, create a new one
        t = create();
        lock.put(t, now);
        return t;
    }

    public synchronized void TakeIn(T t)
    {
        lock.remove(t);
        unlock.put(t, System.currentTimeMillis());
    }


}
