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
			Bienvenide
			<c:out value="${user.nombre } al Paque Tierra Media">
			</c:out>
		</h2>
		<br>
		<div class="row ">
			<div class="col-lg-6">
				<div class="card">
					<img src="../assets/images/lake.jpg" class="card-img-top" alt="..."
						style="height: 9em;">
					<div class="card-body">
						<h4 class="card-title">Mis Atracciones</h4>
						<p class="card-text">
							Atracciones <br>recomendadas <br>según tu preferencia.
						</p>
						<a href="misAtracciones.do" class="btn btn-primary">Ver más</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6">
				<div class="card">
					<img src="../assets/images/montain.jpg" class="card-img-top"
						alt="..." style="height: 9em;">
					<div class="card-body">
						<h4 class="card-title">Mis Promociones</h4>
						<p class="card-text">
							Promociones <br>exclusivas <br>según tu preferencia.
						</p>
						<a href="misPromociones.do" class="btn btn-primary">Ver más</a>
					</div>
				</div>
			</div>
		</div>
		
		
		
		<br>
		<div class="d-grid gap-2">
			<a href="all.do" class="btn btn-success">Ver todo</a>
		</div>
	</div>
	






	<br>
	<jsp:include page="/partials/footer.jsp"></jsp:include>

</body>
</html>