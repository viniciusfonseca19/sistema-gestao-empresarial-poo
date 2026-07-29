package database.repository;

import config.DatabaseConfig;
import database.model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoRepository {

    public boolean salvar(Produto produto){

        String sql =  """
                INSERT INTO produto(nome, preco, estoque)
                VALUES (?, ?, ?)
                """;


        try (
                Connection connection = DatabaseConfig.getConnection();

                PreparedStatement statement =
                        connection.prepareStatement(sql);
        ) {

            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getPreco());
            statement.setInt(3, produto.getEstoque());

            int linhasAfetadas = statement.executeUpdate();

            return linhasAfetadas > 0;

        } catch (SQLException e) {

            System.out.println("Erro ao salvar produto.");
            System.out.println(e.getMessage());

            return false;

        }
    }
}
