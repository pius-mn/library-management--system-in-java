
import java.sql.Connection;
import java.sql.DriverManager;
public class db {
    public static Connection getConnection(){
		Connection connection=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/myDatabase", "root", "");
            System.out.println("connected ");
		}catch(Exception e){System.out.println(e);}
		return connection;
	}
}
