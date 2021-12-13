<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>

<link rel="stylesheet" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">

</head>


<body>
	<jsp:include page="../partials/nav.jsp"></jsp:include>

	<div class="col-lg-6 mx-auto py-md-3">
		<table id="atracciones" class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Atracci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Cupo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atraccionesUser}" var="attraction">
					<tr>
						<td><strong><c:out value="${attraction.nombre}"></c:out></strong>
							<p>
								Esta es una atracción de
								<c:out value="${attraction.tipo}"></c:out>
							</p></td>
						<td><c:out value="${attraction.costo}"></c:out></td>
						<td><c:out value="${attraction.tiempoPromedio}"></c:out></td>
						<td><c:out value="${attraction.cupo}"></c:out></td>

						<td><c:if test="${user.admin}">
								<a href="editAtr.do?id=${attraction.id}"
									class="btn btn-info rounded" role="button" title= "Editar"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="deleteAtr.do?id=${attraction.id}"
									class="btn btn-danger rounded" role="button" title= "Eliminar"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if> <c:choose>

								<c:when
									test="${user.puedePagar(attraction) && user.tieneTiempo(attraction) && attraction.hayCupo() && !miItinerario.contiene(attraction)}">
									<a href="comprarAtr.do?id=${attraction.id}"
										class="btn btn-success rounded" role="button" title= "Comprar"> <i
										class="bi bi-cart3"></i></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button"><i class="bi bi-cart3"></i></a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
    <script>
        $(document).ready(function() {
            $('#atracciones').DataTable({
        		language: { url: "https://cdn.datatables.net/plug-ins/1.10.19/i18n/Spanish.json" }
        	});
            } );
    </script>
    
    
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>

</body>
</html>
