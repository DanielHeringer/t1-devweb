package domain;

import java.sql.Date;

public class Paciente {

	private Long paci_id;
	private String paci_email;
	private String paci_senha;
	private String paci_cpf;
	private String paci_nome;
	private String paci_telefone;
	private String paci_sexo;
	private Date paci_data_nascimento;
	
	public Paciente(Long paci_id) {
		this.paci_id = paci_id;
	}
	
	public Paciente(String paci_nome, String paci_email, String paci_senha, String paci_telefone, String paci_cpf, String paci_sexo, Date paci_data_nascimento ) {
		super();
		this.paci_nome = paci_nome;
		this.paci_email = paci_email;
		this.paci_senha = paci_telefone;
		this.paci_cpf = paci_cpf;
		this.paci_sexo = paci_sexo;
		this.paci_data_nascimento = paci_data_nascimento;
	}
	
	public Paciente(Long paci_id, String paci_nome, String paci_email, String paci_senha, String paci_telefone, String paci_cpf, String paci_sexo, Date paci_data_nascimento ) {
		super();
		this.paci_id = paci_id;
		this.paci_nome = paci_nome;
		this.paci_email = paci_email;
		this.paci_senha = paci_senha;
		this.paci_telefone = paci_telefone;
		this.paci_cpf = paci_cpf;
		this.paci_sexo = paci_sexo;
		this.paci_data_nascimento = paci_data_nascimento;
	}
	
	public Long getId() {
		return paci_id;
	}	
	public void setId(Long paci_id) {
		this.paci_id = paci_id;
	}
	
	public String getNome() {
		return paci_nome;
	}
	public void setNome(String paci_nome) {
		this.paci_nome = paci_nome;
	}
	
	public String getEmail() {
		return paci_email;
	}
	public void setEmail(String paci_email) {
		this.paci_email = paci_email;
	}
	
	public String getSenha() {
		return paci_senha;
	}
	public void setSenha(String paci_senha) {
		this.paci_senha = paci_senha;
	}
	
	public String getTelefone() {
		return paci_telefone;
	}
	
	public void setCTelefone(String paci_telefone) {
		this.paci_telefone = paci_telefone;
	}
	
	public String getCPF() {
		return paci_cpf;
	}
	
	public void setCPF(String paci_cpf) {
		this.paci_cpf = paci_cpf;
	}
	
	public String getSexo() {
		return paci_sexo;
	}
	
	public void setSexo(String paci_sexo) {
		this.paci_sexo = paci_sexo;
	}
	
	public Date getDataNascimento() {
		return paci_data_nascimento;
	}
	
	public void setDataNascimento(Date paci_data_nascimento) {
		this.paci_data_nascimento = paci_data_nascimento;
	}
}