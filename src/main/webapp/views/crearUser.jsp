<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>
</head>


<body>
	<jsp:include page="../partials/header.jsp"></jsp:include>

<br><br>
<div class="col-lg-5 mx-auto p-3 py-md-5">
	<form action="crearUser" method="post">
		<div class="modal-body">
			<div class="mb-3">
				<label for="name" class="col-form-label">Nombre:</label> <input
					type="text" class="form-control" id="name" name="name" required
					value="${user.nombre}">
			</div>
			
			
			<div class="mb-3">
				<label for="password"
					class="col-form-label">Contraseña:</label>
				<input class="form-control" type="password" id="password"
					name="capacity" required value="${user.password}"></input>
				
			</div>
		</div>
		<div>
			<button type="submit" class="btn btn-primary">Guardar</button>
			<a onclick="window.history.back();" class="btn btn-secondary"
				role="button">Cancelar</a>
		</div>

</form>
</div>
		<jsp:include page="/partials/footer.jsp"></jsp:include>
</body>
</html>