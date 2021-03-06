
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>


<script type="text/javascript" src="assets/javascripts/atracciones.js"></script>
</head>
<body>
	<jsp:include page="/partials/header.jsp"></jsp:include>

	<section id="Aventura">
	<p style="color: white;">.</p>
	<br>
	<br>
	
	
 <br>
		<h2 class="p-3">Atracciones de aventura</h2>

		<div class="container row ">
		<c:forEach items="${misAtracciones}" var="atraccion">
		
		<c:if test="${ atraccion.tipo=='AVENTURA'}">
		<div class="col-sm-3">
				<div class="card">
					<div class="card-body">
						<h3 class="card-title"><c:out value="${atraccion.nombre }"></c:out></h3>
						<p class="card-text">Costo:&nbsp<c:out value="${atraccion.costo } monedas"></c:out> <br>
						Duraci?n:&nbsp<c:out value="${atraccion.tiempoPromedio } h"></c:out></p>
						<a href="#" class="btn btn-secondary invisible">Ver m?s</a>
					</div>
				</div>
			</div>
		</c:if>
		</c:forEach>
		</div>
		</section>
		
		<section id="Degustacion">
	

		<h2 class="p-4" >Atracciones de degustaci?n</h2>

		<div class="container  row">
		<c:forEach items="${misAtracciones}" var="atraccion">
		
		<c:if test="${ atraccion.tipo=='DEGUSTACION'}">
		<div class="col-sm-3">
				<div class="card">
					<div class="card-body">

						<h3 class="card-title"><c:out value="${atraccion.nombre }"></c:out></h3>
						<p class="card-text">Costo:&nbsp<c:out value="${atraccion.costo } monedas"></c:out> <br>
						Duraci?n:&nbsp<c:out value="${atraccion.tiempoPromedio } h"></c:out></p>
						<a href="#" class="btn btn-secondary invisible">Ver m?s</a>
					</div>
				</div>
			</div>
		</c:if>
		</c:forEach>
		
		</div>
		</section>
		
		<section id="Paisaje" >

		<h2 class="p-3" >Atracciones de paisaje</h2>

		<div class="container row" >
		<c:forEach items="${misAtracciones}" var="atraccion">
		
		<c:if test="${ atraccion.tipo=='PAISAJE'}">
		<div class="col-sm-3">
				<div class="card">
					<div class="card-body">
						<h3 class="card-title"><c:out value="${atraccion.nombre }"></c:out></h3>
						<p class="card-text">Costo:&nbsp<c:out value="${atraccion.costo } monedas"></c:out> <br>
						Duraci?n:&nbsp<c:out value="${atraccion.tiempoPromedio } h"></c:out> </p>
						<a href="#" class="btn btn-secondary invisible">Ver m?s</a>
					</div>
				</div>
			</div>
		</c:if>
		</c:forEach>
		
		</div>
		</section>
	
<br>
	<jsp:include page="/partials/footer.jsp"></jsp:include>

</body>
</html>