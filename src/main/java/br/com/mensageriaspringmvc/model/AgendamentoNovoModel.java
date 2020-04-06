package br.com.mensageriaspringmvc.model;

public class AgendamentoNovoModel {

	private String descricao;
	private String prioridade;
	private String dataHoraEnvio;
	
	public AgendamentoNovoModel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return String.format("%s - %s - %s",this.getDescricao(), this.getPrioridade(), this.getDataHoraEnvio());
	}
	
	public void setDescricao(String descricao)
	{
		this.descricao= descricao;
	}
	
	public String getDescricao()
	{
		return descricao;
	}
	
	public void setPrioridade(String prioridade)
	{
		this.prioridade= prioridade;
	}
	
	public String getPrioridade()
	{
		return prioridade;
	}
	
	public void setDataHoraEnvio(String dataHoraEnvio)
	{
		this.dataHoraEnvio= dataHoraEnvio;
	}
	
	public String getDataHoraEnvio()
	{
		return dataHoraEnvio;
	}
}
