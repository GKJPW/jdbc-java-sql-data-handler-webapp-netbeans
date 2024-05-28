package NewPackage1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "DisplayDataServlet", urlPatterns = {"/DisplayDataServlet"})
public class DisplayDataServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Database connection settings
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/userinfo";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Load the JDBC driver
            Class.forName(JDBC_DRIVER);

            // Establish the database connection
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);

            // Prepare the SQL query
            String sql = "SELECT * FROM users";
            ps = conn.prepareStatement(sql);

            // Execute the query
            rs = ps.executeQuery();

            // Process the result set
            out.println("<html><body><table border='1'>");
            out.println("<tr><th>ID</th><th>Name</th><th>Email</th></tr>");
            while (rs.next()) {
                String id = rs.getString("ID");
                String username = rs.getString("Name");
                String email = rs.getString("Email");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + username + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("</tr>");
            }
            out.println("</table></body></html>");

        } catch (ClassNotFoundException e) {
            out.println("JDBC Driver not found: " + e.getMessage());
        } catch (SQLException e) {
            out.println("SQL error: " + e.getMessage());
        } finally {
            // Close the resources
            try {
                if (rs != null) rs.close();
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                out.println("Error closing resources: " + e.getMessage());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Redirect GET requests to POST
        doPost(request, response);
    }
}
