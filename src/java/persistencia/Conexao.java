/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sala308b
 */
public class Conexao {
    
    private Connection conexao;
    
    public Connection conectar(){
    
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //dsn => datasource name 
            //      ou seja string de conexao com o banco de dados
            String dsn = "jdbc:mysql://localhost/restaurante?useTimezone=true&serverTimezone=UTC"; 
        
            if ( null == conexao )
               conexao = DriverManager.getConnection(dsn, "root","123456");
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexao.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        
          return conexao;
    }
}
