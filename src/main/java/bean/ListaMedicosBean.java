package bean;

import dao.MedicoDAO;
import domain.Medico;

import java.util.List;

public class ListaMedicosBean {

	public List<Medico> getMedicos() {
		MedicoDAO dao = new MedicoDAO();
		return dao.getAll();
	}
	
	public List<Medico> getMedicos(String especialidade) {
		MedicoDAO dao = new MedicoDAO();
		List<Medico> lista;
		if (especialidade.length() > 0) {
			lista = dao.getByEspecialidade(especialidade);
		} else {
			lista = dao.getAll();
		}
		return lista;
	}
}