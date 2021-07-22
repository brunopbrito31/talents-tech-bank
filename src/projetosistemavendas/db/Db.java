package projetosistemavendas.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class Db {

    private static Connection conn;

    private static String urlPostgres = "jdbc:postgresql://talents-tech-bank.cvitjixrebr2.us-east-1.rds.amazonaws.com/db_bruno_brito";
    private static String usuario = "brunopbrito31";
    private static String senha =

    public static Connection getConnection(){ // verificar se preciso manter a senha
        if(conn == null){
            try{
                Properties props = loadProperties();
                String url = props.getProperty("urlPostgres");
                Connection conn = DriverManager.getConnection(url,props);
                return conn;

            } catch (SQLException e) {
                throw new DbException("Erro na conexão: "+e.getMessage());
            }
        }else {
            return conn;
        }
    }

    public static Properties loadProperties() {
        try(FileInputStream fs = new FileInputStream("db.properties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }catch (IOException e){
            throw new DbException(e.getMessage());
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
        if (st != null){
            try{
                st.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResultSet (ResultSet rs){
        if (rs != null){
            try{
                rs.close();
            }catch (SQLException e){
                throw new DbException(e.getMessage());
            }
        }
    }

}
