/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miracle
 */
public class ajax extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        String s=request.getParameter("email");
    try
        {
            Class.forName("com.ibm.db2.jcc.DB2Driver");
                    System.out.println("driver is loaded");
                    Connection con=DriverManager.getConnection("jdbc:db2://172.17.0.142:50001/itgdb","mssusr2","miracle2");
                    
    out.println("succesfull");
           java.sql.Statement stmt=con.createStatement();

  
 ResultSet rs = stmt.executeQuery("select * from sravani where email='"+s+"'");
        ResultSetMetaData rmd=rs.getMetaData();
            
 if(rs.next())
 
     out.println("true");
 else 
     out.println("false");
     
        }
           
              catch(ClassNotFoundException cnfe)
        {
            System.out.println(cnfe);
        }
     catch(SQLException sql)
     {
         System.out.println(sql);
     }
        }
    }
