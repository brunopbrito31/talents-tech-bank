package projetosistemavendas.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Db {

    private static Connection conn;

    private static String urlPostgres = "jdbc:postgresql://talents-tech-bank.cvitjixrebr2.us-east-1.rds.amazonaws.com/db_bruno_brito";
    private static String usuario = "brunopbrito31";
    private static String senha;

    public static Connection getConnection(String senhaBanco){ // verificar se preciso manter a senha
        if(conn == null){
            try{
                Connection conn = DriverManager.getConnection(urlPostgres,usuario,senhaBanco);
                return conn;

            } catch (SQLException e) {
                throw new DbException("Erro na conexão: "+e.getMessage());
            }
        }else {
            return conn;
        }
    }

    public static void closeConnection (){
        if (conn != null){
            try{
                conn.close();
            }catch(SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement (Statement st) {

    }

}
