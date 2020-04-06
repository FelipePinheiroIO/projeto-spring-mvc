package br.com.mensageriaspringmvc.model;

public class AgendamentoEdicaoModel {

	private Integer id;
	private String descricao;
	private String prioridade;
	private String dataHoraEnvio;
	
	public AgendamentoEdicaoModel()
	{
		
	}
	
	@Override
	public String toString()
	{
		return String.format("%d - %s - %s - %s", this.getId(), this.getDescricao(), this.getPrioridade(), this.getDataHoraEnvio());
	}
	
	public void setId(Integer id)
	{
		this.id= id;
	}
	
	public Integer getId()
	{
		return id;
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
