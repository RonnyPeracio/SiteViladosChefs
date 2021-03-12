/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import persistencia.Conexao;

/**
 *
 * @author RonnyPeracio
 */
@WebServlet(name = "AuthServlet", urlPatterns = {"/Auth"})
public class AuthServlet extends HttpServlet {

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
        
        try {
            
            String email = request.getParameter("email");
            String senha = request.getParameter("senha");
            
            Conexao conexao = new Conexao();
            
            String sql = "select * from usuarios where email = ? and senha = ? ";
            
            //Statement pstm = conexao.conectar().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            PreparedStatement pstm = conexao.conectar().prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, 
                            ResultSet.CONCUR_UPDATABLE);
            
            pstm.setString(1, email);
            pstm.setString(2, md5(senha));           
             
            boolean achou = pstm.execute();
            
            if (achou){
                ResultSet rs = pstm.getResultSet();
              
                 rs.first();
                 
                String nome = rs.getString("nome");
                String login = rs.getString("login");
             
                request.setAttribute("usuario_nome", nome);
                request.setAttribute("usuario_login", login);
                request.setAttribute("usuario_email", email);
                request.setAttribute("usuario_autenticado", true);    
                request.setAttribute("retorno" , " Bem-vindo " + login);
               
                RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
                dispatcher.forward(request, response);
                
            } else {
            
                request.setAttribute("retorno", "Acesso não Autorizado");
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }
            
        } catch (SQLException | NoSuchAlgorithmException ex) {
            request.setAttribute("retorno", ex.getMessage());
              RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
            dispatcher.forward(request, response);
            
        } 

        
        }
     
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public String md5(String s) throws NoSuchAlgorithmException{
    
        MessageDigest m=MessageDigest.getInstance("MD5");
        m.update(s.getBytes(),0,s.length());
        return new BigInteger (1,m.digest()).toString(16);
    }

}
