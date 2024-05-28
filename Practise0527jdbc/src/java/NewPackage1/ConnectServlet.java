/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package NewPackage1;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//::::::::::::::::::::::::::::::::
//::::::::::::::NEW IMPORTS BELOW

import java.sql.Connection; //newly added
import java.sql.SQLException;
import java.sql.DriverManager;//newly added
import java.sql.Statement;//newly added


/**
 *
 * @author GKJPW
 */
@WebServlet(name = "ConnectServlet", urlPatterns = {"/ConnectServlet"})
public class ConnectServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConnectServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConnectServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

PrintWriter out = response.getWriter(); 
out.println("Data Added Succesfully !");


                String url = "jdbc:mysql://localhost:3306/userinfo"; //database url
                String username = "root";
                String password = "";
                
                 String ID = request.getParameter("ID");
                String Name = request.getParameter("Name");
                String Email = request.getParameter("Email");


                
                try {
                    
                    Class.forName("com.mysql.cj.jdbc.Driver"); //driver class
                    Connection con = DriverManager.getConnection(url,username,password);
                    Statement st = con.createStatement();
                    
                    String sql1= ("INSERT INTO users (ID,Name,Email) values ('"+ID+"','"+Name+"','"+Email+"')");
                    st.executeUpdate(sql1);
//               
                } 
                
                catch (ClassNotFoundException | SQLException e) {
                    System.out.println(e);
                } 
                



    }
    
    
    

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
