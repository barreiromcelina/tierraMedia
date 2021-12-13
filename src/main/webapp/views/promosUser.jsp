<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>

<jsp:include page="../partials/dataTable.jsp"></jsp:include>

</head>


<body>
	<jsp:include page="../partials/nav.jsp"></jsp:include>

	<div class="col-lg-8 mx-auto py-md-3">

		<table id="dataTable" class="table table-stripped table-hover">

			<thead>
				<tr>
					<th>Promoci&oacute;n</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${promosUser}" var="promo">
					<tr>
						<td><strong><c:out value="${promo.nombre}"></c:out></strong>
							<p>
								Esta es una promoción de
								<c:out value="${promo.tipo} que incluye "></c:out>
								<c:out value="${promo.promos }"></c:out>
							</p> <c:if test="${promo.tipoPromo=='ABSOLUTA'}">
							 Precio final por el paquete </c:if> <c:if
								test="${promo.tipoPromo=='A_X_B'}">
							 La última atracción es gratis! </c:if> <c:if
								test="${promo.tipoPromo=='PORCENTUAL'}">
							 Descuento de <c:out
									value="${promo.descuento*100} % aplicado en el precio final "></c:out>
							</c:if></td>


						<td><c:out value="${promo.costo}"></c:out></td>
						<td><c:out value="${promo.tiempoPromedio}"></c:out></td>

						<td><c:if test="${user.admin}">
								<a href="" class="btn btn-info rounded" role="button"
									title="Editar"><i class="bi bi-pencil-fill"></i></a>
								<a href="deletePromo.do?id=${promo.id}" class="btn btn-danger rounded" role="button"
									title="Eliminar"><i class="bi bi-x-circle-fill"></i></a>
							</c:if> <c:choose>

								<c:when
									test="${user.puedePagar(promo) && user.tieneTiempo(promo) && promo.hayCupo() && !user.itinerarioContiene(promo)}">


									<a href="comprarPromo.do?id=${promo.id}" class="btn btn-success rounded" role="button"

										title="Comprar"> <i class="bi bi-cart3"></i></a>
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

	<jsp:include page="/partials/footer.jsp"></jsp:include>

</body>
</html>