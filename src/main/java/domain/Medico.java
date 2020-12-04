package domain;

public class Medico {

	private Long medi_id;
	private String medi_email;
	private String medi_senha;
	private String medi_crm;
	private String medi_nome;
	private String medi_telefone;

	public Medico(Long medi_id) {
		this.medi_id = medi_id;
	}
	
	public Medico(String medi_email, String medi_senha, String medi_crm, String medi_nome, String medi_telefone) {
		super();
		this.medi_email = medi_email;
		this.medi_senha = medi_senha;
		this.medi_crm = medi_crm;
		this.medi_nome = medi_nome;
		this.medi_telefone = medi_telefone;
	}
	
	public Medico(Long medi_id, String medi_email, String medi_senha, String medi_crm, String medi_nome, String medi_telefone) {
		super();
		this.medi_id = medi_id;
		this.medi_email = medi_email;
		this.medi_senha = medi_senha;
		this.medi_crm = medi_crm;
		this.medi_nome = medi_nome;
		this.medi_telefone = medi_telefone;
	}
	
	public Long getId() {
		return medi_id;
	}	
	public void setId(Long medi_id) {
		this.medi_id = medi_id;
	}
	
	public String getNome() {
		return medi_nome;
	}
	public void setNome(String medi_nome) {
		this.medi_nome = medi_nome;
	}
	
	public String getEmail() {
		return medi_email;
	}
	public void setEmail(String medi_email) {
		this.medi_email = medi_email;
	}
	
	public String getSenha() {
		return medi_senha;
	}
	public void setSenha(String medi_senha) {
		this.medi_senha = medi_senha;
	}
	
	public String getTelefone() {
		return medi_telefone;
	}
	
	public void setTelefone(String medi_telefone) {
		this.medi_telefone = medi_telefone;
	}
	
	public String getCRM() {
		return medi_crm;
	}
	
	public void setCRM(String medi_crm) {
		this.medi_crm = medi_crm;
	}
	

}