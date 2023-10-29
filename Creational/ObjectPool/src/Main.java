import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**

 Object pool pattern is a software creational design pattern which is used in situations where the cost of initializing a class instance is very high.

 Basically, an Object pool is a container which contains some amount of objects.
 So, when an object is taken from the pool, it is not available in the pool until it is put back.

 Objects in the pool have a lifecycle:
    Creation
    Validation
    Destroy.

 Advantages
    -It offers a significant performance boost.
    -It manages the connections and provides a way to reuse and share them.
    -Object pool pattern is used when the rate of initializing an instance of the class is high.

 When to use Object Pool Design Pattern
    -When we have a work to allocates or deallocates many objects
    -Also, when we know that we have a limited number of objects that will be in memory at the same time.


 About the Object Pooling pattern:
 https://www.geeksforgeeks.org/object-pool-design-pattern/
 https://sourcemaking.com/design_patterns/object_pool

 About JDBC:
 https://www.geeksforgeeks.org/introduction-to-jdbc/

 Download MySQL:
 https://www.mysql.com/products/community/

 JDBC Connector with MYSQL:
 https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.0.33

 Try-with-resouces:
 https://docs.oracle.com/javase/tutorial/essential/exceptions/tryResourceClose.html


 **/
public class Main
{
    public static void main(String[] args)
    {
        //Note: make sure the JDBC driver is set up correctly by going to
        // File > Project Structure > add a new module > and select the jar file from the git repo folder
        //Also make sure your MySQL server is up and running

        System.out.println("---ObjectPooling with JDBC---");
        //Create the ConnectionPool:
        //I was working with MySQL, but you can use different DBMS-s, but you will have to change the driver and url
        //my schema is called "main", the user is "root" and password is "abc"
        JDBCConnectionPool pool = new JDBCConnectionPool("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/main", "root", "abc");

        //Get a connection from the pool:
        Connection con = pool.TakeOut();

        //try-with-resources statement:
        try (Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM table1")) //I have a table named "table1" with a couple of tuples
        {
            while (rs.next())
            {
                int numColumns = rs.getMetaData().getColumnCount();
                //Column numbers start at 1.
                for (int i = 1; i <= numColumns; i++)
                {
                    // Also, there are many methods on the result set to return the column as a particular type.
                    System.out.println( "Column " + i + " = " + rs.getObject(i));
                }
                //for example by specifying the name of the column: (in my table it is called "name")
                System.out.println("Person in this tuple is called: " + rs.getObject("name"));
                System.out.println("");
            }
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }

        //Return the connection to the pool:
        pool.TakeIn(con);

        System.out.println("------");
    }
}