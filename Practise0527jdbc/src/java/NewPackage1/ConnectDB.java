// T E S T F I L E      CREATED FOR TESTING PURPOSE !!!!
// T E S T F I L E      
// T E S T F I L E      CREATED FOR TESTING PURPOSE !!!!
// T E S T F I L E      
// T E S T F I L E      CREATED FOR TESTING PURPOSE !!!!
// T E S T F I L E      
// T E S T F I L E      CREATED FOR TESTING PURPOSE !!!!
// T E S T F I L E      
// T E S T F I L E      CREATED FOR TESTING PURPOSE !!!!
// T E S T F I L E      
// T E S T F I L E      CREATED FOR TESTING PURPOSE !!!!
// T E S T F I L E      
// T E S T F I L E      CREATED FOR TESTING PURPOSE !!!!
// T E S T F I L E      
// T E S T F I L E      CREATED FOR TESTING PURPOSE !!!!


package NewPackage1;

import jakarta.resource.cci.ResultSet;//newly added
import java.util.logging.Level;
import java.util.logging.Logger;//needed but already added by NB
import java.sql.Connection; //newly added
import java.sql.SQLException;
import java.sql.DriverManager;//newly added
import java.sql.Statement;//newly added
import java.sql.*;

/**
 *
 * @author GKJPW
 */
public class ConnectDB {
    

    
            public static void main(String [] args)
            {
                String url = "jdbc:mysql://localhost:3306/userinfo"; //database url
                String username = "root";
                String password = "";
                

                
                try {
                    
                    Class.forName("com.mysql.cj.jdbc.Driver"); //driver class
                    Connection con = DriverManager.getConnection(url,username,password);
                    Statement st = con.createStatement();
                    
                    String sql= ("INSERT INTO users (ID,Name,Email) values (1002,'Nova Augusta','nova@gmail.com')");
                    st.executeUpdate(sql);
//                    ResultSet rs = st.executeQuery("select * from users");
//                    
//                    while(rs.next())
//                    {
//                        System.out.println(rs.getInt(1) +""+ rs.getString(2)+""+ rs.getString(3));
//                    }
                } 
                
                catch (ClassNotFoundException | SQLException e) {
                    System.out.println(e);
                } 
                

            }
    
}