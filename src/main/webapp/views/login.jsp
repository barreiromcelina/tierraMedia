<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="../partials/header.jsp"></jsp:include>


	<div class="col-lg-5 mx-auto p-3 py-md-5">

		<main class="p-5 " >
		<br>
			<h3 class=" ">Turismo en la Tierra Media</h3>


			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
			
			
			<c:if test="${message != null}">
				<div class="alert alert-success ">
					<p>
						<c:out value="${message}" />
					</p>
				</div>
			</c:if>

			<form action="login" method="post">

				<div class="mb-3">
					<label for="username" class="form-label">Usuario</label> <input
						class="form-control" name="username">
				</div>

				<div class="mb-3">
					<label for="password" class="form-label">Contraseña</label> <input
						type="password" class="form-control" name="password">
				</div>

				<div class="d-grid gap-2">
					<button type="submit" class="btn btn-lg btn-primary">Ingresar</button>
					<a href="crearUser" class="btn btn-secondary">Crear usuario</a>
				</div>
			</form>

		</main>
	</div>
	<jsp:include page="/partials/footer.jsp"></jsp:include>


</body>
</html>