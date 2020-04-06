package br.com.mensageriaspringmvc.model;

public class MensagemEmailEdicaoModel {

	private Integer id;
	private String type="Email";
	private String destinatario;
	private String emCopia;
	private String emCopiaOculta;
	private String mensagem;
	
	public MensagemEmailEdicaoModel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return String.format("%d - %s - %s - %s - %s - %s", this.getId(), this.getType(), this.getDestinatario(), this.getEmCopia(), this.getEmCopiaOculta(), this.getMensagem());
	}
	
	public void setId(Integer id)
	{
		this.id= id;
	}
	
	public Integer getId()
	{
		return id;
	}
	
	public String getType()
	{
		return type;
	}
	
	public void setDestinatario(String destinatario)
	{
		this.destinatario= destinatario;
	}
	
	public String getDestinatario()
	{
		return destinatario;
	}
	
	public void setEmCopia(String emCopia)
	{
		this.emCopia= emCopia;
	}
	
	public String getEmCopia()
	{
		return emCopia;
	}
	
	public void setEmCopiaOculta(String emCopiaOculta)
	{
		this.emCopiaOculta= emCopiaOculta;
	}
	
	public String getEmCopiaOculta()
	{
		return emCopiaOculta;
	}
	
	public void setMensagem(String mensagem)
	{
		this.mensagem= mensagem;
	}
	
	public String getMensagem()
	{
		return mensagem;
	}
}
