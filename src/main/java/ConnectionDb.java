
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectionDb{



   public static  Connection createDBconnection()
    {
        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bankdb","root","Sushant@416");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return con;
    }
}
