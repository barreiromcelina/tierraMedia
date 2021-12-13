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
					<th>Producto</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${all}" var="producto">
					<tr>
						<c:if test="${producto.esPromo()}">
						<td><strong><c:out value="${producto.nombre}"></c:out></strong>
							<p>
								Esta es una promoción de
								<c:out value="${producto.tipo} que incluye "></c:out>
								<c:out value="${producto.promos }"></c:out>
							</p> <c:if test="${producto.tipoPromo=='ABSOLUTA'}">
							 Precio final por el paquete </c:if> <c:if
								test="${producto.tipoPromo=='A_X_B'}">
							 La última atracción es gratis! </c:if> <c:if
								test="${producto.tipoPromo=='PORCENTUAL'}">
							 Descuento de <c:out
									value="${producto.descuento*100} % aplicado en el precio final "></c:out>
							</c:if></td>
							</c:if>
							
							<c:if test="${!producto.esPromo()}">
							<td><strong><c:out value="${producto.nombre}"></c:out></strong>
							<p>
								Esta es una atracción de
								<c:out value="${producto.tipo}"></c:out>
							</p></td>
							
							</c:if>


						<td><c:out value="${producto.costo}"></c:out></td>
						<td><c:out value="${producto.tiempoPromedio}"></c:out></td>

						<td><c:if test="${!producto.esPromo()}">
						<c:if test="${user.admin}">
						
								<a href="editAtr.do?id=${producto.id}" class="btn btn-info rounded" role="button"
									title="Editar"><i class="bi bi-pencil-fill"></i></a>
								<a href="deleteAtr.do?id=${producto.id}" class="btn btn-danger rounded" role="button"
									title="Eliminar"><i class="bi bi-x-circle-fill"></i></a>
							</c:if>
							
							 <c:choose>

								<c:when
									test="${user.puedePagar(producto) && user.tieneTiempo(producto) && producto.hayCupo()}">
									<a href="comprarAtr.do?id=${producto.id}" class="btn btn-success rounded" role="button"
										title="Comprar"> <i class="bi bi-cart3"></i></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button"><i class="bi bi-cart3"></i></a>
								</c:otherwise>
							</c:choose></c:if>
							
							
							
							<c:if test="${producto.esPromo()}">
								<c:if test="${user.admin}">
								
								<a href="" class="btn btn-info rounded" role="button"
									title="Editar"><i class="bi bi-pencil-fill"></i></a>
								<a href="deletePromo.do?id=${producto.id}" class="btn btn-danger rounded" role="button"
									title="Eliminar"><i class="bi bi-x-circle-fill"></i></a>
							</c:if>
							
							
							<c:choose>

								<c:when
									test="${user.puedePagar(producto) && user.tieneTiempo(producto) && producto.hayCupo()}">
									<a href="" class="btn btn-success rounded" role="button"
										title="Comprar"> <i class="bi bi-cart3"></i></a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button"><i class="bi bi-cart3"></i></a>
								</c:otherwise>
							</c:choose></c:if></td>



					</tr>
				</c:forEach>
			</tbody>
		</table>
		</div>
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>

</body>
</html>