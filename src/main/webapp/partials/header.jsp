<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header>	
	
		<div class="u-clearfix u-sheet u-sheet-1 fixed-top">
			<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-fixed-top">
				<div class="container-fluid">
					<a href="welcome.jsp" class="u-image u-logo u-image-1"
						data-image-width="221" data-image-height="104"> <img
						src="../assets/images/logoSF.png" class="u-logo-image u-logo-image-1">
					</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarScroll"
						aria-controls="navbarScroll" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarScroll">
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
						<form class="d-flex">
							<input class="form-control me-2" type="search"
								placeholder="Search" aria-label="Search">
							<button class="btn btn-outline-success" type="submit">Buscar</button>
						</form>
					</div>
				</div>
			</nav>

		</div>
		</header>