import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionPool extends ObjectPool<Connection>
{

    private String url;
    private String user;
    private String password;

    public JDBCConnectionPool(String driver, String url, String user, String password)
    {
        super();
        try
        {
            //Class.forName(driver).newInstance() is deprecated ->
            Class.forName(driver).getDeclaredConstructor().newInstance();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    protected Connection create()
    {
        try
        {
            return (DriverManager.getConnection(url, user, password));
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void dead(Connection o)
    {
        try
        {
            o.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    protected boolean validate(Connection o)
    {
        try
        {
            return !o.isClosed();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public synchronized Connection TakeOut() {
        return super.TakeOut();
    }
}
