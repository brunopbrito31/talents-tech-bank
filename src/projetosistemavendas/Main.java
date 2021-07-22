package projetosistemavendas;

import projetosistemavendas.db.Db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main(String[] args) {
        String senha = System.getenv("l_pssdpsql");
        System.out.println("Senha da variavel : "+senha);


        Connection conn = Db.getConnection();



        try(Statement st = conn.createStatement()){
            String query = "SELECT 1 as ID, 'Maria' AS NOME";
            ResultSet rs = st.executeQuery(query);

            while (rs.next()){
                System.out.println("ID: "+rs.getInt("ID"));
                System.out.println("NOME: "+rs.getString("NOME"));
            }
            rs.close();

        }catch (SQLException e){
            System.out.println("Erro no processamento das queries: "+e.getMessage());
        }


    }
}
