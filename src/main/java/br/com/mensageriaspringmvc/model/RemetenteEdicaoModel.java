package br.com.mensageriaspringmvc.model;

public class RemetenteEdicaoModel {

	private Integer id;
	private String nome;
	private String email;
	private String celular;
	
	public RemetenteEdicaoModel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return String.format("%d - %s - %s - %s",this.getId(), this.getNome(), this.getEmail(), this.getCelular());
	}
	
	public void setId(Integer id)
	{
		this.id= id;
	}
	
	public Integer getId()
	{
		return id;
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
