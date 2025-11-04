package org.example.repository;

import org.example.model.Produto;
import org.example.util.ConexaoBanco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class  ProdutoRepositoryImpl implements ProdutoRepository{

    @Override
    public Produto save(Produto produto) throws SQLException {
        String command = "INSERT INTO produto (nome, preco, quantidade, categoria) VALUES (?, ?, ?, ?)";

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(command, Statement.RETURN_GENERATED_KEYS)){

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getCategoria());
            stmt.executeUpdate();

            ResultSet rs = stmt.getGeneratedKeys();

            if (rs.next()) {
                produto.setId(rs.getInt(1));
            }

        }
        return produto;
    }

    @Override
    public List<Produto> findAll() throws SQLException{
        String query = "SELECT id, nome, preco, quantidade, categoria FROM produto WHERE 1 = 1";

        List<Produto> lista = new ArrayList<>();

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                Double preco = rs.getDouble("preco");
                int qntdd = rs.getInt("quantidade");
                String cat = rs.getString("categoria");

                var prod = new Produto(id, nome, preco, qntdd, cat);
                lista.add(prod);
            }
        }
        return lista;
    }

    @Override
    public Produto findById(int id) throws SQLException {
        String query = "SELECT id, nome, preco, quantidade, categoria FROM produto WHERE id = ?";

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nome = rs.getString("nome");
                Double preco = rs.getDouble("preco");
                int qntdd = rs.getInt("quantidade");
                String cat = rs.getString("categoria");

                return new Produto(id, nome, preco, qntdd, cat);
            }
        } catch (SQLException e){
            return null;
        }
        return null;
    }

    @Override
    public Produto update(Produto produto) throws SQLException {
        String query = "UPDATE produto SET nome = ?, preco = ?, quantidade = ?, categoria = ? WHERE id = ?";

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());
            stmt.setInt(3, produto.getQuantidade());
            stmt.setString(4, produto.getCategoria());
            stmt.setInt(5, produto.getId());
            stmt.executeUpdate();

        }
        return produto;
    }

    @Override
    public void deleteById(int id) throws SQLException {
        String query = "DELETE FROM produto WHERE id = ?";

        try(Connection conn = ConexaoBanco.conectar();
            PreparedStatement stmt = conn.prepareStatement(query)){

            stmt.setInt(1, id);
            stmt.executeUpdate();

        }
    }
}
