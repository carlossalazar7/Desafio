<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
<title>Admin Page</title>

<%@ include file="cabecera.jsp"%>
</head>
<%
if ((request.getSession(false).getAttribute("Editor") == null)) {
%>
<jsp:forward page="/JSP/Login.jsp"></jsp:forward>
<%
	}
%>
<body>
<%@ include file="navbar/navbar.jsp"%>
<div class="container">
<br>
		<div>	
			<h3 class="mx-auto text-center">Lista de Ofertas</h3>
 
 		<a type="button" class="btn btn-primary btn-md "
					href="<%=request.getContextPath()%>/GestionOfertas.do?op=nuevo"> Agregar nueva Oferta</a>
 				<br/><br/>
	
		<table class="table table-striped table-bordered w-75 mx-auto table-hover"
					id="tabla">
					<thead class="table table-dark">
						<tr>
							<th>Codigo</th>
							<th>Nombre</th>
							<th>Precio Normal</th>
							<th>Precio Oferta</th>
							<th>Fecha Inicio</th>
							<th>Fecha Final</th>
							<th>Cantidad Cupones</th>
							<th>Descripción</th>
							<th>Estado</th>
							<th>Fecha limite</th>							
							<th>Justificación</th>
							<th>Codigo Empresa</th>
							<th>Modificar</th>
							<th>Eliminar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${requestScope.listarOfertas}" var="oferta">
							<tr>
								<td>${oferta.idPromocion }</td>
								<td>${oferta.nombreOferta}</td>
								<td>${oferta.precioNormal}</td>
								<td>${oferta.precioOferta}</td>
								<td>${oferta.fechaInicio}</td>
								<td>${oferta.fechaFinal}</td>
								<td>${oferta.cantidadCupones}</td>
								<td>${oferta.descripcion}</td>								
								<td>${oferta.estado}</td>
								<td>${oferta.fechaLimite}</td>								
								<td>${oferta.justificacion}</td>
								<td>${oferta.idEmpresa}</td>
								<td><a class="btn btn-primary"
									href="<%=request.getContextPath()%>/GestionOfertas.do?op=obtener&id=${oferta.idPromocion}">
										<span class="glyphicon glyphicon-edit"></span> Editar
								</a></td>
								<td> <a class="btn btn-danger" 	href="javascript:eliminar('${oferta.idPromocion}')"> <span class="glyphicon glyphicontrash"></span> Eliminar
								</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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
		
    	function eliminar(id){
   		 alertify.confirm("¿Realmente decea eliminar esta Empress?", function(e){
   	 	if(e){
   	 		location.href="GestionOfertas?op=eliminar&id="+ id;
   	 	}
   	 });
   	 }
        </script>
        
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
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