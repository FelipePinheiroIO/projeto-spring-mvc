package br.com.mensageriaspringmvc.model;

public class MensagemNotificacaoNovoModel {

	private String type="Notificacao";
	private String destinatario;
	private String mensagem;
	
	public MensagemNotificacaoNovoModel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return String.format("%s - %s - %s", this.getType(), this.getDestinatario(), this.getMensagem());
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
