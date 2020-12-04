package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import domain.Paciente;
import domain.Usuario;
import java.sql.Date;

public class PacienteDAO extends GenericDAO {
    
    public void insert(Paciente paciente) {    
        String sql = "INSERT INTO Paciente (paci_id, paci_email, paci_senha, paci_cpf, paci_nome, paci_telefone, paci_sexo, paci_data_nascimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;    
            statement = conn.prepareStatement(sql);
            statement.setLong(1, paciente.getId());
            statement.setString(2, paciente.getEmail());
            statement.setString(3, paciente.getSenha());
            statement.setString(4, paciente.getCPF());
            statement.setString(5, paciente.getNome());
            statement.setString(6, paciente.getTelefone());
            statement.setString(7, paciente.getSexo());
            statement.setString(8, paciente.getDataNascimento().toString());

            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Paciente> getAll() {   
        List<Paciente> listaPaciente = new ArrayList<Paciente>();
        String sql = "SELECT * from Paciente";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long paci_id = resultSet.getLong("paci_id");
                String paci_email = resultSet.getString("paci_email");
                String paci_senha = resultSet.getString("paci_senha");
                String paci_crm = resultSet.getString("paci_crm");
                String paci_nome = resultSet.getString("paci_nome");
                String paci_telefone = resultSet.getString("paci_telefone");
                String paci_sexo = resultSet.getString("paci_sexo");
                Date paci_data = resultSet.getDate("paci_data_nascimento");

                Paciente paciente = new Paciente(paci_id, paci_email, paci_senha, paci_crm, paci_nome, paci_telefone, paci_sexo, paci_data);
                listaPaciente.add(paciente);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPaciente;
    }
    
    public void delete(Paciente paciente) {
        String sql = "DELETE FROM Paciente where paci_id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, paciente.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(Paciente paciente) {
        String sql = "UPDATE Paciente SET paci_email = ? , paci_senha = ? , paci_cpf= ?, paci_nome= ?, paci_telefone= ?, paci_sexo=?, paci_data_nascimento=? WHERE paci_id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, paciente.getEmail());
            statement.setString(2, paciente.getSenha());
            statement.setString(3, paciente.getCPF());
            statement.setString(4, paciente.getNome());
            statement.setString(5, paciente.getTelefone());
            statement.setString(6, paciente.getSexo());
            statement.setDate(7, paciente.getDataNascimento());
            statement.setLong(8, paciente.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Paciente login(String paci_email, String paci_senha) {
    	Paciente paciente = null;
        String sql = "SELECT * from Paciente WHERE paci_email = ? AND paci_senha = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, paci_email);
            statement.setString(2, paci_senha);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long paci_id = resultSet.getLong("paci_id");
                String paci_cpf = resultSet.getString("paci_cpf");
                String paci_nome = resultSet.getString("paci_nome");
                String paci_telefone = resultSet.getString("paci_telefone");
                String paci_sexo = resultSet.getString("paci_sexo");
                Date paci_data = resultSet.getDate("paci_data_nascimento");
                paciente = new Paciente(paci_id, paci_email, paci_senha, paci_cpf, paci_nome, paci_telefone,paci_sexo, paci_data);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return paciente;
    }
    
}