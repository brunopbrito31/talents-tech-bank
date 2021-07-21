package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String urlPostgres = "jdbc:postgresql://talents-tech-bank.cvitjixrebr2.us-east-1.rds.amazonaws.com/db_bruno_brito";
        String usuario = "brunopbrito31";
        String senha;
        try{
            System.out.print("Digite a senha do banco de dados: ");
            senha =reader.nextLine();
            Connection conn = DriverManager.getConnection(urlPostgres, usuario, senha);
            Statement stnt = conn.createStatement();
            String query = "select 1 as id, 'Mariana' as nome";
            ResultSet rs =stnt.executeQuery(query);
            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id"));
                System.out.println("NOME: "+rs.getString("nome"));
            }
            rs.close();
            reader.close();
;        }catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }

}
