package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import domain.Consulta;
import domain.Medico;
import domain.Paciente;


import java.sql.Date;
import java.sql.Timestamp;


public class ConsultaDAO extends GenericDAO {

    public void insert(Consulta consulta) {
        String sql = "INSERT INTO Consulta ( paci_id, medi_id, cons_data_hora) VALUES (?, ?, ?)";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);;
            statement = conn.prepareStatement(sql);
            statement.setLong(1, consulta.getPaciente());
            statement.setLong(2, consulta.getMedico());
            statement.setTimestamp(3, consulta.getDate());
            
        System.out.println(statement);
            statement.executeUpdate();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Consulta> getAll(Medico medico) {

        List<Consulta> listaConsultas = new ArrayList<>();

        String sql = "SELECT * from Consulta c where c.medi_id = ? order by c.cons_id";

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, medico.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("cons_id");
                Long paciente = resultSet.getLong("paci_id");
                Long medicoid = resultSet.getLong("medi_id");
                Timestamp data = resultSet.getTimestamp("cons_data_hora");
                Consulta consulta = new Consulta(id, paciente, medicoid, data);
                listaConsultas.add(consulta);

            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsultas;
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
            statement.setTimestamp(3, consulta.getDate());
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
                Timestamp cons_data_hora = resultSet.getTimestamp("cons_data_hora");

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

    public List<Consulta> getAllPaciente(Paciente paciente) {

        List<Consulta> listaConsultas = new ArrayList<>();

        String sql = "SELECT * from Consulta c where c.paci_id = ? order by c.cons_data_hora";

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, paciente.getId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong("cons_id");
                Long medicoid = resultSet.getLong("medi_id");
                Timestamp data = resultSet.getTimestamp("cons_data_hora");
                Consulta consulta = new Consulta(id, paciente.getId(), medicoid, data);
                listaConsultas.add(consulta);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaConsultas;
    }


    public List<Consulta> getbyMedico(Long medi_id) {
    	Consulta consulta = null;
    	List<Consulta> lista = new ArrayList<>();
        String sql = "SELECT * from Consulta as c WHERE  c.medi_id = ?";
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, medi_id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	Long cons_id = resultSet.getLong("cons_id");
                Long paci_id = resultSet.getLong("paci_id");
                Timestamp cons_data_hora = resultSet.getTimestamp("cons_data_hora");
                consulta = new Consulta(cons_id, paci_id, medi_id, cons_data_hora);
                lista.add(consulta);

            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
