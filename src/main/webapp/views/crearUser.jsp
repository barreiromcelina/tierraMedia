<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>
</head>


<body>
	<jsp:include page="../partials/header.jsp"></jsp:include>

	<br>
	<br>
	<div class="col-lg-5 mx-auto p-3 py-md-5">
		<form action="crearUser" method="post">
		
		<c:if test="${user != null && !user.isValid()}">
			<br><div class="alert alert-danger">
				<p> <c:out value=" ${user.errors}"></c:out> </p>
			</div>
		</c:if>
			<div class="modal-body">
			
			
				<div class="mb-3">
					<label for="name" class="col-form-label">Nombre:</label> <input
						type="text" class="form-control" id="name" name="name" required
						value="${user.nombre}">
				</div>


				<div class="mb-3">
					<label for="password" class="col-form-label">Contraseña:</label> <input
						class="form-control" type="password" id="password" name="password"
						required value="${user.password}"></input>
				</div>
				<div class="mb-3">
					<label for="presupuesto" class="col-form-label">Presupuesto:</label>
					<input class="form-control" type="number" id="presupuesto" step="any"
						name="presupuesto" required value="${user.presupuesto}"></input>
				</div>
				<div class="mb-3">
					<label for="tiempoDisponible" class="col-form-label">Tiempo
						disponible:</label> <input class="form-control" type="number"
						id="tiempoDisponible" step="any" name="tiempo" required
						value="${user.tiempoDisponible}"></input>
				</div>
				<div class="mb-3">
					<label for="tipoPreferido" class="col-form-label">Tipo
						atraccion preferida:</label> <select name="tipoPreferido"
						class="form-select" aria-label="Default select example">
						<c:forEach items="${tipos}" var="unTipo">
							<option value="${unTipo }"><c:out value="${unTipo }"></c:out></option>
						</c:forEach>
					</select>

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