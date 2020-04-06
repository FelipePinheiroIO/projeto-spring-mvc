package br.com.mensageriaspringmvc.model;

public class RemetenteNovoModel {

	private String nome;
	private String email;
	private String celular;
	
	public RemetenteNovoModel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return String.format("%s - %s - %s",this.getNome(), this.getEmail(), this.getCelular());
	}
	
	public void setNome(String nome)
	{
		this.nome= nome;
	}
	
	public String getNome()
	{
		return nome;
	}
	
	public void setEmail(String email)
	{
		this.email= email;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setCelular(String celular)
	{
		this.celular= celular;
	}
	
	public String getCelular()
	{
		return celular;
	}
}
