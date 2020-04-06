<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<style>
.projeto-bg-body { background-color: #E8EBF1; }
.projeto-bg-green { background-color: #28a745; }
.projeto-bg-purple { background-color: #6f42c1; }
.projeto-btn-green { background-color: #28a745; }
.projeto-pt-80 {padding-top:80px;}
.rounded { border-radius: 20px!important; }
.projeto-btn-add { background-color: #6f42c1; top: 56px; position: fixed; left: 992px; z-index: 2; border-radius: 0px 0px 20px 20px;    }
.projeto-btn-add:hover { background-color:#06586b }
.projeto-btn-icone-add { background-image: url("/Images/btn-icone-add.png"); width:50px; height:100px; background-repeat: no-repeat; margin-left: auto; margin-right: auto; cursor: pointer; position: relative; top: -18px; }
.projeto-btn-icone-add:hover { background-image: url("/Images/btn-icone-add-hover.png"); width:50px; height:100px; background-repeat: no-repeat; margin-left: auto; margin-right: auto; cursor: pointer; position: relative; top: -18px; }
.projeto-btn-icone-add-text { color:#28a745; font-weight: bold; font-size: 18px; margin-left: auto; margin-right: auto; position: relative; top: -18px; left:40px; }
.projeto-margin-lr-auto { margin-left: auto; margin-right: auto; }
</style>
</head>
<body class="projeto-bg-body">

	<nav class="navbar fixed-top navbar-expand-lg navbar-dark projeto-bg-green">

            <button class="navbar-toggler" type="button" data-toggle="collapse" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse ">

                 <ul class="navbar-nav mr-auto">
                   <li class="nav-item">
                       <a class="nav-link" href="/agendamentos">Agendamentos</a>
                    </li>
                 </ul>

            </div>
        </nav>
        
        

          <div class="container projeto-pt-80">
          <c:if test="${agendamentos == null}">
	          	<div class="col-12 pb-5 pr-0">
	                  <a href="/agendamento-novo" class="btn projeto-btn-add ml-5 float-right text-white font-weight-bold"> 
	                    <span class="float-left ml-2 pt-1 pr-1">Novo Agendamento</span>
	                  </a>
	              </div>
        	</c:if>
        	<c:forEach var="agendamento" items="${agendamentos}">
              <div class="my-3 p-3 bg-white shadow-sm rounded">
		            <div class="align-items-center p-2 my-3 projeto-bg-green text-white rounded shadow-sm">
		                <div class="row">
		                    <div class="col-6 pt-2 pl-4">
		                        <span class="font-weight-bold pr-2">AGENDAMENTO:</span> ${agendamento.descricao}
		                    </div>
		                    <div class="col-6">
		                    
		                        <a href=agendamento-remocao/${agendamento.id} class="btn btn-danger rounded ml-3 float-right text-white font-weight-bold"> 
		                            <span class="float-left ml-2 pt-1 pr-1">Remover</span>
		                        </a>       
		
		                    	<a href=agendamento-edicao/${agendamento.id} class="btn btn-warning rounded float-right text-white font-weight-bold"> 
		                            <span class="float-left ml-2 pt-1 pr-1">Editar</span>
		                        </a>    
		
		                    </div>
		                </div>
		            </div>
		                      
		            <div class="row py-2">
		
		                <div class="col-6">
		                    <div class="col-12 font-weight-bold">
		                        Prioridade: 
		                    </div>
		                    <div class="col-12">
		                        ${agendamento.prioridade}
		                    </div>
		                </div>
		
		                  <div class="col-6">
		                    <div class="col-12 font-weight-bold">
		                        Dia/Hora do envio:
		                    </div>
		                    <div class="col-12">
		                         ${agendamento.dataHoraEnvio}
		                    </div>
		                </div>
		            </div>
		            
		        </div>
		        
		        <c:if test="${agendamento.remetente != null}">
			        <div class="my-3 p-3 bg-white shadow-sm rounded">
			            <div class="align-items-center p-2 my-3 projeto-bg-purple text-white rounded shadow-sm">
			                <div class="row">
			                    <div class="col-6 pt-2 pl-4">
			                        <span class="font-weight-bold pr-2">REMETENTE, ENVIAR MENSAGEM EM NOME DE:</span> ${agendamento.remetente.nome}
			                    </div>
			                    <div class="col-6">
			                    
			                        <a href=agendamentos/remetente-remocao/${agendamento.remetente.id} class="btn btn-danger rounded ml-3 float-right text-white font-weight-bold"> 
			                            <span class="float-left ml-2 pt-1 pr-1">Remover</span>
			                        </a>       
			
			                    	<a href=agendamentos/remetente-edicao/${agendamento.remetente.id} class="btn btn-warning rounded float-right text-white font-weight-bold"> 
			                            <span class="float-left ml-2 pt-1 pr-1">Editar</span>
			                        </a>    
			
			                    </div>
			                </div>
			            </div>
			                      
			            <div class="row py-2">
			
			                <div class="col-6">
			                    <div class="col-12 font-weight-bold">
			                        E-mail: 
			                    </div>
			                    <div class="col-12">
			                        ${agendamento.remetente.email}
			                    </div>
			                </div>
			
			                  <div class="col-6">
			                    <div class="col-12 font-weight-bold">
			                        Celular:
			                    </div>
			                    <div class="col-12">
			                         ${agendamento.remetente.celular}
			                    </div>
			                </div>
			            </div>	            
			        </div>
		        </c:if>
		        
		        <c:forEach var="mensagem" items="${agendamento.mensagens}">
			        <div class="my-3 p-3 bg-white shadow-sm rounded">
			            <div class="align-items-center p-2 my-3 bg-secondary text-white rounded shadow-sm">
			                <div class="row">
			                    <div class="col-6 pt-2 pl-4">
			                        <span class="font-weight-bold pr-2">MENSAGEM DE : ${mensagem.type}</span>
			                    </div>
			                    <div class="col-6">
			                        <c:set var = "tipoMensagem" value = "${fn:toLowerCase(mensagem.type)}" />
			                        <a href=agendamentos/mensagem-${tipoMensagem}-remocao/${mensagem.id} class="btn btn-danger rounded ml-3 float-right text-white font-weight-bold"> 
			                            <span class="float-left ml-2 pt-1 pr-1">Remover</span>
			                        </a>       
			
			                    	<a href=agendamentos/mensagem-${tipoMensagem}-edicao/${mensagem.id} class="btn btn-warning rounded float-right text-white font-weight-bold"> 
			                            <span class="float-left ml-2 pt-1 pr-1">Editar</span>
			                        </a>    
			
			                    </div>
			                </div>
			            </div>
			                      
			            <div class="row py-2">
						
						<c:if test="${mensagem.type != 'Email'}">
			
			                <div class="col-6">
			                    <div class="col-12 font-weight-bold">
			                        Destinatário: 
			                    </div>
			                    <div class="col-12">
			                        ${mensagem.destinatario}
			                    </div>
			                </div>
			                  
			                 <div class="col-6">
			                    <div class="col-12 font-weight-bold">
			                        Mensagem:
			                    </div>
			                    <div class="col-12">
			                         ${mensagem.mensagem}
			                    </div>
			                </div>
			                
			              </c:if>
			              
			              <c:if test="${mensagem.type == 'Email'}">
			
			                <div class="col-3">
			                    <div class="col-12 font-weight-bold">
			                        Destinatário: 
			                    </div>
			                    <div class="col-12">
			                        ${mensagem.destinatario}
			                    </div>
			                </div>
			
			                  <div class="col-3">
			                    <div class="col-12 font-weight-bold">
			                        Em Cópia:
			                    </div>
			                    <div class="col-12">
			                         ${mensagem.emCopia}
			                    </div>
			                </div>
			                 <div class="col-3">
			                    <div class="col-12 font-weight-bold">
			                        Em Cópia Oculta:
			                    </div>
			                    <div class="col-12">
			                         ${mensagem.emCopiaOculta}
			                    </div>
			                </div>
			                 <div class="col-3">
			                    <div class="col-12 font-weight-bold">
			                        Mensagem:
			                    </div>
			                    <div class="col-12">
			                         ${mensagem.mensagem}
			                    </div>
			                </div>
			                
			              </c:if>
			               
			               
			            </div>	            
			        </div>
		        </c:forEach>
		        
		        <c:if test="${agendamento.remetente == null}">
		        	<a href=agendamentos/${agendamento.id}/remetente-novo><div class="projeto-btn-icone-add"></div></a>
		       		<div class="col-3 projeto-btn-icone-add-text">Adicionar Remetente</div>
		        </c:if>
		        
		        <c:if test="${agendamento.remetente != null}">
		        	
		       		<div class="col-4 projeto-margin-lr-auto">
		       		   
			       		<div class="col-12 mt-5 projeto-btn-icone-add-text">Adicionar Mensagem De:</div>
			       		
			       		 <a href=agendamentos/${agendamento.id}/mensagem-email-novo class="btn bg-secondary rounded ml-3 float-right text-white font-weight-bold"> 
				              <span class="float-left ml-2 pt-1 pr-1">E-mail</span>
				         </a> 
				         <a href=agendamentos/${agendamento.id}/mensagem-sms-novo class="btn bg-secondary rounded ml-3 float-right text-white font-weight-bold"> 
				              <span class="float-left ml-2 pt-1 pr-1">Sms</span>
				         </a> 
				         <a href=agendamentos/${agendamento.id}/mensagem-notificacao-novo class="btn bg-secondary rounded ml-3 float-right text-white font-weight-bold"> 
				              <span class="float-left ml-2 pt-1 pr-1">Notificação</span>
				         </a> 
			      	</div>
		        </c:if>
		       
		       </c:forEach>
		       
		       
           </div>
           
 
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>