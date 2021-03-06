<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
<title>Nueva Oferta</title>

<%@ include file="cabecera.jsp"%>
</head>

<body>
<%@ include file="navbar/navbar.jsp"%>
<div class="container">
<br>
		<div>	
			<form role="form" action="<%=request.getContextPath()%>/GestionOfertas.do" method="POST">
 						<input type="hidden" name="op" value="insertar">
 							<div class="well well-sm">
 								<strong><span class="glyphicon glyphicon-asterisk">
 									</span>Campos requeridos
 								</strong>
 							</div>
 							
							<div class="form-group">
 								<label for="nombre">Nombre de la Oferta</label>
 								<div class="input-group">
 									<input type="text" class="form-control" name="nombre"
											id="nombre" value="${oferta.nombreOferta}" 
											placeholder="Ingresa el nombre de la Oferta" >
 										<span class="input-group-addon">
 											<span class="glyphicon glyphicon-asterisk"></span>
 										</span>
 								</div>
 							</div>
 							<div class="form-group">
 								<label for="contacto">Precio Normal</label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="precion"
											value="${oferta.precioNormal}" name="precion" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
 							
 							<div class="form-group">
 								<label for="contacto">Precio de Oferta </label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="preciof"
											value="${oferta.precioNormal}" name="preciof" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
 							
 							<div class="form-group">
 								<label for="contacto">Fecha Inicio</label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="fechai"
											value="${oferta.fechaInicio}" name="fechai" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
 							<div class="form-group">
 								<label for="contacto">Fecha Final</label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="fechaf"
											value="${oferta.fechaFinal}" name="fechaf" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
 							<div class="form-group">
 								<label for="contacto">Cantidad de Cupones</label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="cupones"
											value="${oferta.cantidadCupones}" name="cupones" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
							
							<div class="form-group">
 								<label for="contacto">Descripción</label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="descripcion"
											value="${oferta.descripcion}" name="descripcion" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
 							<div class="form-group">
 								<label for="contacto">Estado</label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="estado"
											value="En espera" name="estado" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
 							<div class="form-group">
 								<label for="contacto">Fecha Limite de uso de Cupones</label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="fechal"
											value="${oferta.fechaLimite}" name="fechal" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
 							<div class="form-group">
 								<label for="contacto">Justificación</label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="justificacion"
											value="En espera" name="justificacion" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
 							
 							<div class="form-group">
 								<label for="contacto">ID de Empresa</label>
 								<div class="input-group">
											<textarea rows="5" cols="10" class="form-control" id="empresa"
											value="${oferta.idEmpresa}" name="empresa" 
											placeholder="Ingresa uan descripcion del genero" ></textarea>
 									<span class="input-group-addon">
 										<span class="glyphicon glyphicon-asterisk"></span>
 									</span>
 								</div>
 							</div>
	 						<input type="submit" class="btn btn-info" value="Guardar" name="Guardar">
 								<a class="btn btn-danger" href="${pageContext.request.contextPath}/GestionOfertas.do?op=listar">Cancelar</a>
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