<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
<title>Nueva Empresa</title>

<%@ include file="cabecera.jsp"%>
</head>
<%
if ((request.getSession(false).getAttribute("Admin") == null)) {
%>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%
	}
%>
<body>
<%@ include file="navbar/navbar.jsp"%>
<div class="container">
<br>
		<div class="w-50 mx-auto float-center bg-light">	
		<h1 class="text-center">Agregar nueva empresa</h1>
			<form role="form" action="<%=request.getContextPath()%>/EmpresasOfertantes" method="POST">
 						<input type="hidden" name="op" value="insertar">
 							<div class="well well-sm">
 								<strong><span class="glyphicon glyphicon-asterisk">
 									</span>Campos requeridos
 								</strong>
 							</div>
 							
							<div class="form-group w-50 mx-auto">
 								<label for="nombre">Nombre de la empresa</label>
 								<div class="input-group">
 									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${genero.nombreGenero}" 
											placeholder="Ingresa el nombre del Genero" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
 							<div class="form-group w-50 mx-auto">
 								<label for="contacto">Comisi�n:</label>
 								<div class="input-group">
									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${genero.nombreGenero}" 
											placeholder="Ingresa el nombre del Genero" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
 							<div class="form-group w-50 mx-auto">
 								<label for="nombre">Direcci�n:</label>
 								<div class="input-group">
 									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${genero.nombreGenero}" 
											placeholder="Ingresa el nombre del Genero" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
 							<div class="form-group w-50 mx-auto">
 								<label for="nombre">Contacto:</label>
 								<div class="input-group">
 									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${genero.nombreGenero}" 
											placeholder="Ingresa el nombre del Genero" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
 							<div class="form-group w-50 mx-auto">
 								<label for="nombre">Telefono:</label>
 								<div class="input-group">
 									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${genero.nombreGenero}" 
											placeholder="Ingresa el nombre del Genero" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
 							<div class="form-group w-50 mx-auto">
 								<label for="nombre">Correo:</label>
 								<div class="input-group">
 									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${genero.nombreGenero}" 
											placeholder="Ingresa el nombre del Genero" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
 							<div class="form-group w-50 mx-auto">
 								<label for="nombre">Direcci�n:</label>
 								<div class="input-group">
 									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${genero.nombreGenero}" 
											placeholder="Ingresa el nombre del Genero" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
 							<div class="form-group w-50 mx-auto">
 								<label for="nombre">Rubro:</label>
 								<div class="input-group">
 						<c:forEach items="${requestScope.nuevo}" var="generos">
 							<tr>
 								<td>${generos.idRubro}</td>
 								<td>${generos.nombreRubro}</td>
							 </tr>
 						</c:forEach>
 									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${genero.RubroBean}" 
											placeholder="Ingresa el nombre del Genero" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
						<div class="form-group w-50 mx-auto">
 								<label for="nombre">Password:</label>
 								<div class="input-group">
 									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${genero.nombreGenero}" 
											placeholder="Ingresa el nombre del Genero" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
	 						<input type="submit" class="btn btn-info" value="Guardar" name="Guardar">
 								<a class="btn btn-danger" href="${pageContext.request.contextPath}/EmpresasOfertantes?op=listar">Cancelar</a>
 						</form>
		</div>
	
</body> <script>
        	
        $(document).ready(function(){
    	 	$('#tabla').DataTable();
    	 });
    	 
    	 <c:if test="${not empty exito}">
    	 	alertify.success('${exito}');
    	 	<c:set var="exito" value="" scope="session" />
    	 
    	 </c:if>
    	 
    	 <c:if test="${not empty fracaso}">
    	 	alertify.error('${fracaso}');
    		<c:set var="fracaso" value="" scope="session" />
    	 
    	</c:if>
		
        </script>
        
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</html>
</html>