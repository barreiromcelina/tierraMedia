<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>
</head>


<body>
	<jsp:include page="../partials/header.jsp"></jsp:include>
<div class="p-5">
<div class="p-5">

	<form class="form-floating col-lg-5 mx-auto p-5 py-md-5 t-5">
		<div class="form-floating mb-3 t-5">
			<input type="text" class="form-control required" id="floatingInput"
				placeholder="name@example.com"> <label for="floatingInput">Nombre
				y Apellido</label>
		</div>

		<div class="form-floating mb-3">
			<input type="email" class="form-control is-invalid required"
				id="floatingInputInvalid" placeholder="name@example.com"> <label
				for="floatingInputInvalid">Mail</label>

		</div>

		<div class="form-floating mb-3">
			<textarea class="form-control required" placeholder="Leave a comment here"
				id="floatingTextarea"></textarea>
			<label for="floatingTextarea" >Consulta</label>
		</div>
		<div class="col-12">
			<button class="btn btn-primary" type="submit">Enviar</button>
		</div>
	</form>

</div>
</div>

<div class="fixed-bottom">
	<jsp:include page="/partials/footer.jsp"></jsp:include>
</div>


</body>
</html>