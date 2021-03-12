/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import persistencia.Conexao;

/**
 *
 * @author RonnyPeracio
 */
public class ContatoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            processRequest(req, resp);
            
            Conexao conexao = new Conexao();
            
           // JOptionPane.showMessageDialog(null, "Contato recebido: " + req.getParameter("id"));
            String sql = "delete from restaurante.clientes where cliente_id = ?"; 
            
            PreparedStatement pstm = conexao.conectar().prepareStatement(sql);
            pstm.setString(1, req.getParameter("id"));
            
            pstm.executeUpdate();
            
                    
        } catch (SQLException ex) {
            Logger.getLogger(ContatoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            doGet(req, resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

        
        String origem = req.getParameter("origem");
        req.setAttribute("origem", origem);
        
        //JOptionPane.showMessageDialog(null, origem);
        
        String contato_id = req.getParameter("id");

        //JOptionPane.showMessageDialog(null, "Contato recebido: " + req.getParameter("_method"));
        if (req.getParameter("_method") != null) {
            doDelete(req, resp);
        } else {

            if (contato_id.equals("0")) {
                
                incluir(req, resp);

            } else {

                atualizar(req, resp);

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
        
        String origem = "clientes.jsp";
        
        if ( req.getAttribute("origem") != null ){
            origem = req.getAttribute("origem").toString() ; 
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher(origem);
        dispatcher.forward(req, resp);
    }

    protected void incluir(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

        try {

            //JOptionPane.showMessageDialog(null, "Salvando: " + req.getParameter("nome"));
            
            String nome = req.getParameter("nome");
            String celular = req.getParameter("celular");
            String email = req.getParameter("email");
            String senha = req.getParameter("senha");
            String desejo = req.getParameter("desejo");
            String tipo_entrega = "retirar";
            String cep = req.getParameter("cep");
            String logradouro = req.getParameter("logradouro");
            String numero = req.getParameter("numero");
            String complemento = req.getParameter("complemento");
            String bairro = req.getParameter("bairro");
            String cidade = req.getParameter("cidade");
            String estado = req.getParameter("estado");

            Conexao conexao = new Conexao();
            String sql = " insert into restaurante.clientes (cliente_nome, cliente_celular,";
            sql += " cliente_email, cliente_senha, cliente_desejo, cliente_tipo_entrega,";
            sql += " cliente_cep, cliente_logradouro, cliente_numero, cliente_complemento, ";
            sql += " cliente_bairro, cliente_cidade, cliente_estado)";
            sql += "values (? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";

            PreparedStatement pstm;

            pstm = conexao.conectar().prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.setString(2, celular);
            pstm.setString(3, email);
            pstm.setString(4, senha);
            pstm.setString(5, desejo);
            pstm.setString(6, tipo_entrega);
            pstm.setString(7, cep);
            pstm.setString(8, logradouro);
            pstm.setString(9, numero);
            pstm.setString(10, complemento);
            pstm.setString(11, bairro);
            pstm.setString(12, cidade);
            pstm.setString(13, estado);
            pstm.executeUpdate();

            pstm.close();

            req.setAttribute("retorno", " TOP!! Registro salvo com sucesso.");

            conexao.conectar().close();

        } catch (SQLException ex) {
            req.setAttribute("retorno", ex.getMessage());

        } finally {

            doGet(req, resp);

        }
    }

    protected void atualizar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);

        try {

            String id = req.getParameter("id");
            String nome = req.getParameter("nome");
            String celular = req.getParameter("celular");
            String email = req.getParameter("email");
            String cep = req.getParameter("cep");
            String logradouro = req.getParameter("logradouro");
            String numero = req.getParameter("numero");
            String complemento = req.getParameter("complemento");
            String bairro = req.getParameter("bairro");
            String cidade = req.getParameter("cidade");

            Conexao conexao = new Conexao();
            String sql = " update restaurante.clientes set cliente_nome=?, cliente_celular=?,";
            sql += " cliente_email=?, ";
            sql += " cliente_cep=?, cliente_logradouro=?, cliente_numero=?, cliente_complemento=?, ";
            sql += " cliente_bairro=?, cliente_cidade=? ";
            sql += " where cliente_id=? ";

            PreparedStatement pstm;

            pstm = conexao.conectar().prepareStatement(sql);
            pstm.setString(1, nome);
            pstm.setString(2, celular);
            pstm.setString(3, email);
            pstm.setString(4, cep);
            pstm.setString(5, logradouro);
            pstm.setString(6, numero);
            pstm.setString(7, complemento);
            pstm.setString(8, bairro);
            pstm.setString(9, cidade);
            pstm.setString(10, id);

            pstm.executeUpdate();

            pstm.close();

            req.setAttribute("retorno", " TOP!! Registro salvo com sucesso.");

            conexao.conectar().close();

        } catch (SQLException ex) {
            req.setAttribute("retorno", ex.getMessage());

        } finally {

            doGet(req, resp);

        }

    }
}
