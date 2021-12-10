<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>
</head>


<body>
	<jsp:include page="../partials/nav.jsp"></jsp:include>
	
	
	<div class="container col-4">

		<h2>

			<c:out value="${user.nombre } estos son los productos que compraste">
			</c:out>
		</h2>
		
		
		<h3> <c:out value="${miItinerario}"></c:out> </h3>
		
		<h4> Costo total: <c:out value="${costoTotal} "> </c:out><i title="monedas" style="color: gold;" class="bi bi-coin"></i> </h4>
		<h4> Duración de la visita: <c:out value="${tiempoTotal} "></c:out> <i title="tiempo" style="color: blue;" class="bi bi-clock"></i> </h4>
		
		</div>
	<br>
	<jsp:include page="/partials/footer.jsp"></jsp:include>


</body>
</html>