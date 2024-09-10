package main.java.br.com.phamtecnologia.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import main.java.br.com.phamtecnologia.entities.Cliente;
import main.java.br.com.phamtecnologia.factories.ConnectionFactory;

public class ClienteRepository {

    public void create(Cliente cliente) throws Exception {

        Connection connection = ConnectionFactory.getConnection();
        
        String query = "INSERT INTO CLIENTE(nome, email, cpf, telefone, observacoes) VALUES(?,?,?,?,?)";
        
        PreparedStatement statement = connection.prepareStatementreparedStatement(query);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getTelefone());
        statement.setString(5, cliente.getObservacoes());
        statement.executeUpdate();

        connection.close();

    }

    public void update(Cliente cliente) throws Exception {
        Connection connection = ConnectionFactory.getConnection();

        String query = "UPDATE CLIENTE SET NOME=?, EMAIL=?, CPF=?, TELEFONE=?, OBSERVACOES=? WHERE idcliente=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, clienet.getTelefone());
        statement.setString(5, cliente.getObservacoes());
        statement.setInt(6, cliente.getIdCliente());
        statement.execute();

        connection.close();

    }

    public void delete(Cliente cliente) throws Exception {
        
        Connection connection = ConnectionFactory.getConnection();

        String query = "DELETE FROM CLIENTE WHERE idcliente=?";

        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, cliente.getIdCliente());
        statement.execute();

        connection.close();

    }

    public List<Cliente> findALL() throws Exception {
        //  TODO
        return null;
    }

    public Cliente findById(Integer idCliente) throws Exception {
        //  TODO
        return null;
    }
}
