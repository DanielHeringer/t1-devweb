package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import domain.Consulta;
import java.sql.Date;


public class ConsultaDAO extends GenericDAO {

    public void insert(Consulta consulta) {    
        String sql = "INSERT INTO Consulta ( paci_id, medi_id, cons_data_hora) VALUES (?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;    
            statement = conn.prepareStatement(sql);
            statement.setLong(1, consulta.getPaciente());
            statement.setLong(2, consulta.getMedico());
            statement.setDate(3, consulta.getDate());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public List<Consulta> getAll() {   
        List<Consulta> listaConsulta = new ArrayList<Consulta>();
        String sql = "SELECT * from Medico ";
        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Long cons_id = resultSet.getLong("cons_id");
                Long paci_id = resultSet.getLong("paci_id");
                Long medi_id = resultSet.getLong("medi_id");
                Date cons_data_hora = resultSet.getDate("cons_data_hora");
                Consulta consulta = new Consulta(cons_id, paci_id, medi_id, cons_data_hora);
                listaConsulta.add(consulta);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsulta;
    }
    
    public void delete(Consulta consulta) {
        String sql = "DELETE FROM Consulta where cons_id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, consulta.getId());
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void update(Consulta consulta) {
        String sql = "UPDATE Consulta SET paci_id = ? , medi_id = ? , cons_data_hora= ? WHERE cons_id = ?";
    
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, consulta.getPaciente());
            statement.setLong(2, consulta.getMedico());
            statement.setDate(3, consulta.getDate());
            statement.setLong(4, consulta.getId());
 
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public Consulta get(Long cons_id) {
    	Consulta consulta = null;
        String sql = "SELECT * from Consulta WHERE cons_id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, cons_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long paci_id = resultSet.getLong("paci_id");
                Long medi_id = resultSet.getLong("medi_id");
                Date cons_data_hora = resultSet.getDate("cons_data_hora");

                consulta = new Consulta(cons_id, paci_id, medi_id, cons_data_hora);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consulta;
    }
    
    public Consulta getbyPaciente(Long paci_id) {
    	Consulta consulta = null;
        String sql = "SELECT * from Consulta WHERE paci_id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, paci_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long cons_id = resultSet.getLong("cons_id");
                Long medi_id = resultSet.getLong("medi_id");
                Date cons_data_hora = resultSet.getDate("cons_data_hora");
                consulta = new Consulta(cons_id, paci_id, medi_id, cons_data_hora);

            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consulta;
    }
}