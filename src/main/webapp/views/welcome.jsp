<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
<jsp:include page="/partials/header.jsp"></jsp:include>
<section id="carousel">
			<div id="carouselExampleDark" class="carousel carousel-dark slide"
				data-bs-ride="carousel">
				<div class="carousel-indicators">
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="0" class="active" aria-current="true"
						aria-label="Slide 1"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="1" aria-label="Slide 2"></button>
					<button type="button" data-bs-target="#carouselExampleDark"
						data-bs-slide-to="2" aria-label="Slide 3"></button>
				</div>
				<div class="carousel-inner container-sm">
					<div class="carousel-item active " data-bs-interval="10000">
						<img src="../assets/images/6.jpg" class="d-block w-100  " alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h1>Atracciones</h1>
							<h5> Tierra Media te está esperando para disfrutar de tus atracciones favoritas</h5>
							<a href="atracciones.html" class="btn btn-info">Ver más</a>
							
						</div>
					</div>
					<div class="carousel-item" data-bs-interval="2000">
						<img src="../assets/images/5.jpg" class="d-block w-100" alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h1>Promociones</h1>
							<h5>Descubrí las promociones disponibles para esta temporada</h5>
								<a href="promociones.html" class="btn btn-info">Ver más</a>
						</div>
					</div>
					<div class="carousel-item">
						<img src="../assets/images/7.jpg" class="d-block w-100" alt="...">
						<div class="carousel-caption d-none d-md-block">
							<h1>Próximamente </h1>
							<h5>Nuevas atracciones llegaran pronto a Tierra Media</h5>
							<button type="button" class="btn btn-info invisible">Ver más</button>
						</div>
					</div>
				</div>
				<button class="carousel-control-prev" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="prev">
					<span class="carousel-control-prev-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Previous</span>
				</button>
				<button class="carousel-control-next" type="button"
					data-bs-target="#carouselExampleDark" data-bs-slide="next">
					<span class="carousel-control-next-icon" aria-hidden="true"></span>
					<span class="visually-hidden">Next</span>
				</button>
			</div>


		</section>
		
		<jsp:include page="/partials/footer.jsp"></jsp:include>
</body>
</html>