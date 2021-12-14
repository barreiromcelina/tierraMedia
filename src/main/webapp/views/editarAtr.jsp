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
		<form action="editAtr.do" method="post">
		<input type="hidden" name="id" value="${atraccion.id}">
			<div class="modal-body">
				<div class="mb-3">
					<label for="name" class="col-form-label">Nombre:</label> <input
						type="text" class="form-control" id="name" name="name" required
						value="${atraccion.nombre}">
				</div>

				<div class="mb-3">
					<label for="costo" class="col-form-label">Costo:</label> <input
						class="form-control" type="number" id="costo" step="any" name="costo"
						required value="${atraccion.costo}"></input>
				</div>
				<div class="mb-3">
					<label for="tiempo" class="col-form-label">Tiempo Promedio:</label>
					<input class="form-control" type="number" id="tiempo" step="any" name="tiempo"
						required value="${atraccion.tiempoPromedio}"></input>
				</div>

				<div class="mb-3">
					<label for="cupo" class="col-form-label">Cupo:</label> <input
						class="form-control" type="number" id="cupo" name="cupo"
						required value="${atraccion.cupo}"></input>
				</div>


				<div>
					<button type="submit" class="btn btn-primary">Guardar</button>
					<a onclick="window.history.back();" class="btn btn-secondary"
						role="button">Cancelar</a>
				</div>
				</div>
		</form>
	</div>
	<jsp:include page="/partials/footer.jsp"></jsp:include>
</body>
</html>