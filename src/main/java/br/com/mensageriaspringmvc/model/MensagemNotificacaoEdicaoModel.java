package br.com.mensageriaspringmvc.model;

public class MensagemNotificacaoEdicaoModel {

	private Integer id;
	private String type="Notificacao";
	private String destinatario;
	private String mensagem;
	
	public MensagemNotificacaoEdicaoModel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return String.format("%d - %s - %s - %s", this.getId(), this.getType(), this.getDestinatario(), this.getMensagem());
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
	
	public void setMensagem(String mensagem)
	{
		this.mensagem= mensagem;
	}
	
	public String getMensagem()
	{
		return mensagem;
	}
}
