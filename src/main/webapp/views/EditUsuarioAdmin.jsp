<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../partials/nav.jsp"></jsp:include>

	
	<br>
	<br>
	<div class="col-lg-5 mx-auto p-3 py-md-5">
		<form action="EditarUsuario.do" method="post">
			<input type="hidden" name="userId" value="${usuario.id}">

			<c:if test="${usuario != null && !usuario.isValid()}">
				<br>
				<div class="alert alert-danger">
					<p>
						<c:out value=" ${usuario.errors}"></c:out>
					</p>
				</div>
			</c:if>

			<div class="modal-body">
				<div class="mb-3">
					<label for="name" class="col-form-label">Nombre:</label> <input
						type="text" class="form-control" id="name" name="name" required
						value="${usuario.nombre}">
				</div>
				<div class="mb-3">

					<label for="admin" class="col-form-label">Admin:</label> <select
						class="form-select" aria-label="Default select example" name="admin">
						<option value="false">No</option>
						<option value="true">Si</option>
					</select>
				</div>

				<div class="mb-3">
					<label for="password" class="col-form-label">Password:</label> <input
						class="form-control" type="password" id="password" name="password"
						required value="****"></input>
				</div>

				<div class="mb-3">
					<label for="presupuesto" class="col-form-label">presupuesto:</label> <input
						class="form-control" type="number" id="presupuesto" step="any"
						name="presupuesto" required value="${usuario.presupuesto}"></input>
				</div>
				<div class="mb-3">
					<label for="tiempoDisponible" class="col-form-label">Tiempo disponible:</label>
					<input class="form-control" type="number" id="tiempoDisponible" step="any"
						name="tiempoDisponible" required value="${usuario.tiempoDisponible}"></input>
				</div>

				<div class="mb-3">
					<label for="tipo" class="col-form-label">Preferencia:</label> <select
						name="tipoPreferido" class="form-select"
						aria-label="Default select example">
						<c:forEach items="${tipos}" var="unTipo">
							<option value="${unTipo }"
								${usuario.tipoAtraccionPreferida == unTipo ? "selected": "" }><c:out
									value="${unTipo }"></c:out></option>
						</c:forEach>
					</select>
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