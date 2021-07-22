package projetosistemavendas;

import projetosistemavendas.db.Db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Digite a senha do banco de dados");
        String senha = reader.nextLine().trim();
        Connection conn = Db.getConnection(senha);


        try(Statement st = conn.createStatement()){
            String query = "SELECT 1 as ID, 'Maria' AS NOME";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                System.out.println("ID: "+rs.getInt("ID"));
                System.out.println("NOME: "+rs.getString("NOME"));
            }
            reader.close();
            rs.close();

        }catch (SQLException e){
            System.out.println("Erro no processamento das queries: "+e.getMessage());
        }


    }
}
