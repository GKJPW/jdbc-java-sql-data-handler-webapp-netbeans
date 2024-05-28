


package NewPackage1;


import java.sql.ResultSet;
import java.sql.Connection; //newly added
import java.sql.SQLException;
import java.sql.DriverManager;//newly added
import java.sql.Statement;//newly added

/**
 *
 * @author GKJPW
 */

    
public class ViewAll {
                static final String url = "jdbc:mysql://localhost:3306/userinfo"; //database url
                static final String username = "root";
                static final String password = "";
                static final String sql = "SELECT * from users";
                
                
    
    public static void main (String []  args)
    {
        try(  Connection con = DriverManager.getConnection(url,username,password);
         Statement st = con.createStatement( ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_READ_ONLY);
        
       
         ResultSet rs = st.executeQuery(sql);   )
                
                
                 {		
            
            while(rs.next())
                    {
                        System.out.println(rs.getInt("ID") +""+ rs.getString("Name")+""+ rs.getString("Email"));
                    }
            

      } catch (SQLException e) {
         e.printStackTrace();
      } 
    }
    
}
