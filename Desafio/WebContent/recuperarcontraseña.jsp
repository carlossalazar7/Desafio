<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Login</title>
	<link rel="stylesheet" 	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Recuperar tu contrasela</title>
</head>
<body>
<div class="bg-img-login   ">
	<br>
	<br>
	<br>
	<br>
	<form name="Email" action="<%=request.getContextPath()%>Email.java"
		method="post">
		<div class=" bg-light w-50 mx-auto">
			<br>
			<h1 class="text-center">¿Olvidaste tu contraseña?</h1>
			<div class="form-group w-75 mx-auto">
				<label for="exampleInputEmail1">Usuario</label> <input type="text"
					placeholder="ingrese su login">
			</div>
			<div class="form-group w-75 mx-auto">
				<label for="exampleInputPassword1">Correo</label> <input
					placeholder="correo electronico">
			</div>
			

			
			<div class="form-group mx-auto text-center">
				<button type="submit" class="btn btn-py " value="Email">Enviar</button>
				<br>
			</div>
			<br>

		</div>
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	</div>
</body>
</html>