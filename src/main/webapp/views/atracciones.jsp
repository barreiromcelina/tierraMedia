
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>


<script type="text/javascript" src="assets/javascripts/atracciones.js"></script>
</head>
<body>
	<jsp:include page="/partials/header.jsp"></jsp:include>

	<br>
	<br>
	<br>
	<br>
	<section id="Aventura">

		<h2 class="p-3">Atracciones de aventura</h2>

		<div class="row ">
		<c:forEach items="${misAtracciones}" var="atraccion">
		
		<c:if test="${ atraccion.tipo=='AVENTURA'}">
		<div class="col-sm-3">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title"><c:out value="${atraccion.nombre }"></c:out></h4>
						<p class="card-text">Costo:&nbsp<c:out value="${atraccion.costo }"></c:out> <br>
						Duración:&nbsp<c:out value="${atraccion.tiempoPromedio }"></c:out></p>
						<a href="#" class="btn btn-secondary">Ver más</a>
					</div>
				</div>
			</div>
		</c:if>
		</c:forEach>
		</div>
		</section>
		
		<section id="Degustacion">

		<h2 class="p-4" >Atracciones de degustación</h2>

		<div class="row">
		<c:forEach items="${misAtracciones}" var="atraccion">
		
		<c:if test="${ atraccion.tipo=='DEGUSTACION'}">
		<div class="col-sm-3">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title"><c:out value="${atraccion.nombre }"></c:out></h4>
						<p class="card-text">Costo:&nbsp<c:out value="${atraccion.costo }"></c:out> <br>
						Duración:&nbsp<c:out value="${atraccion.tiempoPromedio }"></c:out></p>
						<a href="#" class="btn btn-secondary">Ver más</a>
					</div>
				</div>
			</div>
		</c:if>
		</c:forEach>
		
		</div>
		</section>
		
		<section id="Paisaje">

		<h2 class="p-3" >Atracciones de paisaje</h2>

		<div class="row">
		<c:forEach items="${misAtracciones}" var="atraccion">
		
		<c:if test="${ atraccion.tipo=='PAISAJE'}">
		<div class="col-sm-3">
				<div class="card">
					<div class="card-body">
						<h4 class="card-title"><c:out value="${atraccion.nombre }"></c:out></h4>
						<p class="card-text">Costo:&nbsp<c:out value="${atraccion.costo }"></c:out>&nbsp monedas <br>
						Duración:&nbsp<c:out value="${atraccion.tiempoPromedio }"></c:out>&nbsp h</p>
						<a href="#" class="btn btn-secondary">Ver más</a>
					</div>
				</div>
			</div>
		</c:if>
		</c:forEach>
		
		</div>
		</section>
	

	<jsp:include page="/partials/footer.jsp"></jsp:include>

</body>
</html>