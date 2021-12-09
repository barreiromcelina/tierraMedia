<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container">
		<a href="welcome.jsp" class="u-image u-logo u-image-1"
						data-image-width="221" data-image-height="104"> <img
						src="../assets/images/logoSF.png" class="u-logo-image u-logo-image-1">
					</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
		
						<ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
							style="-bs-scroll-height: 100px;">
							<li class="nav-item"><a class="nav-link active"
								aria-current="page" href="welcome.jsp">Inicio</a></li>
							<li class="nav-item"><a class="nav-link" href="login.jsp">Iniciar
									sesión</a></li>
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" 
								id="navbarScrollingDropdown" role="button"
								data-bs-toggle="dropdown" aria-expanded="false"> Atracciones
							</a>
								<ul class="dropdown-menu"
									aria-labelledby="navbarScrollingDropdown">
									<li><a class="dropdown-item" href="atracciones#Aventura">Aventura</a></li>
									<li><a class="dropdown-item" href="atracciones#Degustacion">Degustación</a></li>
									<li><a class="dropdown-item" href="atracciones#Paisaje">Paisaje</a></li>
								</ul></li>
							<li class="nav-item"><a class="nav-link " href="promos">Promociones</a></li>
							<li class="nav-item"><a class="nav-link " href="contact.jsp">Contacto</a></li>
						</ul>
			<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:out value="${user.nombre}"></c:out>
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="monedas" style="color: gold;" class="bi bi-coin"></i> <c:out value="${user.presupuesto} monedas"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="tiempo" style="color: blue;" class="bi bi-clock"></i> <c:out value="${user.tiempoDisponible} h"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;" href="itinerario">
							<i title="book" style="color: green;" class="bi bi-book"> </i>Mi Itinerario
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="/turismo/logout" class="dropdown-item">Salir</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>
