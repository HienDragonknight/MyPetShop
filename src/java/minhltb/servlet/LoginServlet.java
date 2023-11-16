/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minhltb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import minhltb.registration.RegistrationDAO;
import minhltb.util.DBHelper;

/**
 *
 * @author Minh
 */
public class LoginServlet extends HttpServlet {
    private final String SEARCH_PAGE = "search.html";
    private final String INVALID_PAGE = "invalid.html";
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String name = request.getParameter("txtUsername");
//        String password = request.getParameter("txtPassword");
//        if(name.length()==0 && password.length()==0){
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Invalid</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1 style='color:red'> Invalid username or password!!! </h1>");
//            out.println("<p><a href=\"http://localhost:8084/FA23SEHonTap/\">Click here to try again</a></p>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//        }
//        else{
//            response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Home</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Welcome to DB Servlet</h1>");
//            out.println("<form action=\"LoginServlet\" method=\"POST\">\n" +
//        "Name <input type=\"text\" name=\"txtUsername\" value=\"\" /><br/>\n" +
//        "<input type=\"submit\" value=\"Search\" name=\"btAction\" />\n" +
//        "</form>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//        }
//    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
//        String username = request.getParameter("txtUsername");
//        String password = request.getParameter("txtPassword");
//        String button = request.getParameter("tbAction");
//        
//        try {
//            out.println("Username " + username + " - " + password + " - " + button);
//            
//            System.out.println("Username " + username + " - " + password + " - " + button);
//            
//            Connection con = DBHelper.makeConnection();
//            if(con != null){
//                out.println("Database Connected");
//            }else{
//                out.println("Database Connection refuse");
//            }
//        }catch (SQLException ex){
//        ex.printStackTrace();
//        }
//        catch(ClassNotFoundException ex){
//        ex.printStackTrace();
//        }
        
        //1. Get all parameter
        String button = request.getParameter("tbAction");
        String url = INVALID_PAGE;
        
        try {
            if(button.equals("Login")){
               String username = request.getParameter("txtUsername");
               String password = request.getParameter("txtPassword"); 
               //2. Call Model - DAO
               //2.1 New DAO
                RegistrationDAO dao = new RegistrationDAO();
               //2.2 Call method
               boolean result = dao.checkLogin(username, password);
               //3. Process
               if(result == true){
                   //url = SEARCH_PAGE;
                   response.sendRedirect("search.html");
               }//username and password is verify
               else{
                    response.sendRedirect("index.html");
               }
            }
        }catch (SQLException ex){
        ex.printStackTrace();
        }
        catch(ClassNotFoundException ex){
        ex.printStackTrace();
        }
        finally{
            //response.sendRedirect(url);
            out.close();
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
