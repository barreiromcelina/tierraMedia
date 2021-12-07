
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<jsp:include page="../partials/head.jsp"></jsp:include>

<script type="text/javascript" src="assets/javascripts/atracciones.js"></script>

<body>
	<jsp:include page="../partials/header.jsp"></jsp:include>

	
	<table class="table table-stripped table-hover misAtracciones">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Costo</th>
					<th>Duracion</th>
					

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${misAtracciones}" var="atraccion">
					<tr>
						<td><c:out value="${atraccion.nombre}">
							</c:out></td>
						<td><c:out value="${atraccion.costo}">
							</c:out></td>
						<td><c:out value="${atraccion.duracion}">
							</c:out></td>
						<td><a href="/Libreria/editarLibro.do?id=${libro.id}"
							class="btn btn-primary">Editar libro</a>
						</td>
						<td><a href="/Libreria/eliminarLibro.do?id=${libro.id}"
							class="btn btn-primary">Eliminar libro</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	<jsp:include page="../partials/footer.jsp"></jsp:include>

</body>
</html>