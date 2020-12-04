package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import domain.Medico;

public class MedicoDAO extends GenericDAO {

    public void insert(Medico medico) {    
        String sql = "INSERT INTO Medico ( medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;    
            statement = conn.prepareStatement(sql);
            statement.setString(1, medico.getEmail());
            statement.setString(2, medico.getSenha());
            statement.setString(3, medico.getCRM());
            statement.setString(4, medico.getNome());
            statement.setString(5, medico.getTelefone());
            statement.setString(6, medico.getEspecialidade());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Medico> getAll() {   
        List<Medico> listaMedico = new ArrayList<Medico>();
        String sql = "SELECT * from Medico";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long medi_id = resultSet.getLong("medi_id");
                String medi_email = resultSet.getString("medi_email");
                String medi_senha = resultSet.getString("medi_senha");
                String medi_crm = resultSet.getString("medi_crm");
                String medi_nome = resultSet.getString("medi_nome");
                String medi_telefone = resultSet.getString("medi_telefone");
                String medi_especialidade = resultSet.getString("medi_especialidade");
                Medico medico = new Medico(medi_id, medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade);
                listaMedico.add(medico);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaMedico;
    }
    
    public void delete(Medico medico) {
        String sql = "DELETE FROM Medico where medi_id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, medico.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(Medico medico) {
        String sql = "UPDATE Medico SET medi_email = ? , medi_senha = ? , medi_crm= ?, medi_nome= ?, medi_telefone= ? WHERE medi_id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, medico.getEmail());
            statement.setString(2, medico.getSenha());
            statement.setString(3, medico.getCRM());
            statement.setString(4, medico.getNome());
            statement.setString(5, medico.getTelefone());
            statement.setLong(6, medico.getId());
            
            
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Medico get(Long medi_id) {
    	Medico medico = null;
        String sql = "SELECT * from Medico WHERE medi_id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, medi_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	String medi_email = resultSet.getString("medi_email");
                String medi_senha = resultSet.getString("medi_senha");
                String medi_crm = resultSet.getString("medi_crm");
                String medi_nome = resultSet.getString("medi_nome");
                String medi_telefone = resultSet.getString("medi_telefone");
                String medi_especialidade = resultSet.getString("medi_especialidade");
                medico = new Medico(medi_id, medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medico;
    }
    
    public Medico getbyEmail(String medi_email) {
    	Medico medico = null;
        String sql = "SELECT * from Medico WHERE medi_email = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, medi_email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long medi_id = resultSet.getLong("medi_id");
                String medi_senha = resultSet.getString("medi_senha");
                String medi_crm = resultSet.getString("medi_crm");
                String medi_nome = resultSet.getString("medi_nome");
                String medi_telefone = resultSet.getString("medi_telefone");
                String medi_especialidade = resultSet.getString("medi_especialidade");
                medico = new Medico(medi_id, medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medico;
    }
    public Medico login(String medi_email, String medi_senha) {
    	Medico medico = null;
        String sql = "SELECT * from Medico WHERE medi_email = ? AND medi_senha = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, medi_email);
            statement.setString(2, medi_senha);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long medi_id = resultSet.getLong("medi_id");
                String medi_crm = resultSet.getString("medi_crm");
                String medi_nome = resultSet.getString("medi_nome");
                String medi_telefone = resultSet.getString("medi_telefone");
                String medi_especialidade = resultSet.getString("medi_especialidade");
                medico = new Medico(medi_id, medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return medico;
    }
}