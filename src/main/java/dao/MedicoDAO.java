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
	
	private final static String SQL_SELECT_ESPECIALIDADE = "select c.medi_id, c.medi_email, c.medi_senha, c.medi_crm, c.medi_nome, c.medi_telefone, c.medi_especialidade"
            + " from Medico as c"
            + " where UPPER(c.medi_especialidade) like ? "
            + " order by c.medi_nome";
	
	private final static String SQL_SAVE = "insert into Medico"
            + " (medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade) values (?,?)";
	
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
    
    public void save(Medico medico) {
        try {
            PreparedStatement ps = this.connection.prepareStatement(SQL_SAVE,
                    Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, medico.getEmail());
            ps.setString(2, medico.getSenha());
            ps.setString(3, medico.getCRM());
            ps.setString(4, medico.getNome());
            ps.setString(5, medico.getTelefone());
            ps.setString(6, medico.getEspecialidade());
            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            medico.setId(rs.getLong(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public List<Medico> getAll() {   
        List<Medico> listaMedico = new ArrayList<>();
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
                String medico_teste = medi_id + "/" + medi_email + "/" + medi_senha + "/" + medi_crm + "/" + medi_nome + "/" + medi_telefone + "/" + medi_especialidade;
                Medico medico = new Medico(medi_id, medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade);
                listaMedico.add(medico);
            }
            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(listaMedico);
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
    
    public List<Medico> getByEspecialidade(String especialidade) {

        List<Medico> lista = new ArrayList<>();
        String sql = "select medi_id, medi_email, medi_senha, medi_crm, medi_nome, medi_telefone, medi_especialidade from Medico as c where UPPER(c.medi_especialidade) like ? order by c.medi_nome";

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
           //PreparedStatement stmt;
            
            statement.setString(1, especialidade);
            ResultSet resultSet = statement.executeQuery();
            
            //stmt = this.connection.prepareStatement(SQL_SELECT_ESPECIALIDADE);
            //stmt.setString(1, "%"+ especialidade.toUpperCase() + "%");
            //ResultSet res = stmt.executeQuery();

            while (resultSet.next()) {
                Long id = resultSet.getLong(1);
                System.out.println(id);
                String medi_email = resultSet.getString(2);
                System.out.println(medi_email);
                String medi_senha = resultSet.getString(3);
                System.out.println(medi_senha);
                String medi_crm = resultSet.getString(4);
                System.out.println(medi_crm);
                String medi_nome = resultSet.getString(5);
                System.out.println(medi_nome);
                String medi_telefone = resultSet.getString(6);
                System.out.println(medi_telefone);
                String medi_especialidade = resultSet.getString(7);
                System.out.println(medi_especialidade);
                //String medico_teste = id + "/" + medi_email + "/" + medi_senha + "/" + medi_crm + "/" + medi_nome + "/" + medi_telefone + "/" + medi_especialidade; 
                //System.out.println(medico_teste);
                Medico medico = new Medico();
                medico.setId(id);
                medico.setEmail(medi_email);
                medico.setSenha(medi_senha);
                medico.setCRM(medi_crm);
                medico.setNome(medi_nome);
                medico.setTelefone(medi_telefone);
                medico.setEspecialidade(medi_especialidade);
                System.out.println(medico);
                

                lista.add(medico);
                System.out.println(lista);
                //System.out.println(lista[]);
            }
            
            resultSet.close();
            statement.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
    
}