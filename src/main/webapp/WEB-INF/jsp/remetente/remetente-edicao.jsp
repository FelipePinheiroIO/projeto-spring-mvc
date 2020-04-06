<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
        
            <div class="my-3 p-3 bg-white rounded shadow-sm">
              <div class="align-items-center p-3 my-3 projeto-bg-green text-white font-weight-bold rounded shadow-sm">  
                EDITANDO REMETENTE DA MENSAGEM:
              </div>


              <form method="post" action=/agendamentos/remetente-edicao/${remetente.id}>
             
                <div class="form-group">
                  <label>Nome:</label>
                  <input type="text" name="nome" class="form-control rounded" value="${remetente.nome}"></input>
                </div>
                
                 <div class="form-group">
                  <label>E-mail:</label>
                  <input type="text" name="email" class="form-control rounded" value="${remetente.email}"></input>
                 </div>
                 
                 <div class="form-group">
                   <label>Celular:</label>
                   <input type="text" name="celular" class="form-control rounded" value="${remetente.celular}"></input>
                 </div>
                
                  <div class="form-group col-12 py-4">
                    <button type="submit" class="btn projeto-btn-green float-right text-white font-weight-bold rounded">Salvar</button>  
                  </div>

              </form>
            </div>
          </div>
 
	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
</body>
</html>