package domain;
import java.sql.Date;

public class Consulta {

	private Long cons_id;
	private Long paci_id;
	private Long medi_id;
	private Date cons_data_hora;

	public Consulta(Long cons_id) {
		this.cons_id = cons_id;
	}
	
	public Consulta(Long paci_id, Long medi_id, Date cons_data_hora) {
		super();
		this.paci_id = paci_id;
		this.medi_id = medi_id;
		this.cons_data_hora = cons_data_hora;
	}
	
	public Consulta(Long cons_id, Long paci_id, Long medi_id, Date cons_data_hora) {
		super();
		this.cons_id = cons_id;
		this.paci_id = paci_id;
		this.medi_id = medi_id;
		this.cons_data_hora = cons_data_hora;
	}
	
	public Long getId() {
		return cons_id;
	}	
	public void setId(Long cons_id) {
		this.cons_id = cons_id;
	}
	
	public Long getPaciente() {
		return paci_id;
	}
	public void setPaciente(Long paci_id) {
		this.paci_id = paci_id;
	}
	
	public Long getMedico() {
		return medi_id;
	}
	public void setMedico(Long medi_id) {
		this.medi_id = medi_id;
	}
	
	public Date getDate() {
		return cons_data_hora;
	}
	public void setDate(Date cons_data_hora) {
		this.cons_data_hora = cons_data_hora;
	}
	

}