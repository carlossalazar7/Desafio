<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Recuperar tu contrasela</title>
</head>
<body>
<div class="bg-img-login   ">
	<br>
	<br>
	<br>
	<br>
	<form name="form" action="<%=request.getContextPath()%>/LoginServlet"
		method="post">
		<div class=" bg-light w-50 mx-auto">
			<br>
			<h1 class="text-center">¿Olvidaste tu contraseña?</h1>
			<div class="form-group w-75 mx-auto">
				<label for="exampleInputEmail1">Login</label> <input type="text"
					class="form-control" name="username" aria-describedby="emailHelp"
					placeholder="ingrese su login">
				<!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small>  -->
			</div>
			<div class="form-group w-75 mx-auto">
				<label for="exampleInputPassword1">Correo</label> <input
					type="password" class="form-control" name="password"
					placeholder="correo electronico">
			</div>
			

			<div class="form-group mx-auto text-center">
				<span style="color: red"><%=(request.getAttribute("errMessage") == null) ? "" : request.getAttribute("errMessage")%></span>
				<br>
			</div>
			<div class="form-group mx-auto text-center">
				<button type="submit" class="btn btn-primary " value="Login">Enviar</button>
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