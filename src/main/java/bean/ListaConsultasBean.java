package bean;

import dao.ConsultaDAO;
import domain.Consulta;
import domain.Medico;

import java.util.ArrayList;
import java.util.List;

public class ListaConsultasBean {

	public List<Consulta> getConsultas(Long medi_id) {
		ConsultaDAO dao = new ConsultaDAO();
		List<Consulta> lista = new ArrayList<Consulta>();
		lista = dao.getbyMedico(medi_id);
		return lista;
	}
	
}
