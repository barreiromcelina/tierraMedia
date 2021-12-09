<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>
</head>


<body>
	<jsp:include page="../partials/nav.jsp"></jsp:include>
	
	
	<div class="container col-4">
	
	<h2> Bienvenide <c:out value="${user.nombre } al Paque Tierra Media"> </c:out>   </h2>
	<br>
	<div class="row ">
	<div class="col-sm-6">
	<div class="card" >
  <img src="../assets/images/lake.jpg" class="card-img-top" alt="..." style="height: 12rem;">
  <div class="card-body">
    <h4 class="card-title">Mis Atracciones</h4>
    <p class="card-text">Atracciones recomendadas según tu preferencia.</p>
    <a href="misAtracciones.do" class="btn btn-primary">Ver más</a>
  </div>
  </div>
  </div>
  <div class="col-sm-6">
	<div class="card" >
  <img src="../assets/images/montain.jpg" class="card-img-top" alt="..." style="height: 12rem;">
  <div class="card-body">
    <h4 class="card-title">Mis Promociones</h4>
    <p class="card-text">Promociones exclusivas según tu preferencia.</p>
    <a href="misPromociones.do" class="btn btn-primary">Ver más</a>
  </div>
  </div>
  </div>
</div>
	</div>
	
	
	
	
	
	
	
	<jsp:include page="/partials/footer.jsp"></jsp:include>

</body>    
</html>