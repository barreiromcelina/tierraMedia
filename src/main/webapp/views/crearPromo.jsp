<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="../partials/head.jsp"></jsp:include>
</head>


<body>
	<jsp:include page="../partials/header.jsp"></jsp:include>

	<br>
	<br>
	<div class="col-lg-5 mx-auto p-3 py-md-5">
		<form action="crearPromo.do" method="post">
			<input type="hidden" name="id" value="${promocion.id}">
			<div class="modal-body">
				<div class="mb-3">
					<label for="name" class="col-form-label">Nombre:</label> <input
						type="text" class="form-control" id="name" name="name" required
						value="${promocion.nombre}">
				</div>

				<div class="mb-3">
					<label for="tipoAtr" class="col-form-label ">Tipo:
						</label> <select name="tipoAtr" class="form-select"
						aria-label="Default select example">
						<c:forEach items="${tiposAtr}" var="unTipo">
							<option value="${unTipo }"
								${promocion.tipo == unTipo ? "selected": "" }><c:out
									value="${unTipo }"></c:out></option>
						</c:forEach>
					</select>

				</div>

				<div class="mb-3">
					<label for="valor" class="col-form-label">Valor:
						(Porcentual 0-1, Absoluta: Precio Final, AxB=0)</label> <input
						class="form-control" type="number" id="valor" step="any"
						name="valor" required value="${promocion.valor}"></input>
				</div>
				<div class="mb-3">
					<label for="tipo" class="col-form-label">Tipo de promoción:</label>
					<select name="tipo" class="form-select"
						aria-label="Default select example">
						<c:forEach items="${tipos}" var="unTipo">
							<option value="${unTipo }" ${promocion.tipoPromo == unTipo ? "selected": "" }><c:out value="${unTipo }"></c:out></option>
						</c:forEach>
					</select>

				</div>

				<div class="mb-3">
					<label for="atrEnPromo" class="col-form-label">Atracciones en la promo:
						</label> <select multiple name="atrEnPromo" class="form-select"
						aria-label="Default select example">
						<c:forEach items="${atracciones}" var="atr">
							
								<option value="${atr.nombre }"
									${promocion.contiene(atr) ? "selected" : "" }><c:out
										value="${atr.nombre} - "></c:out><c:out value="${atr.tipo}"></c:out></option>
							
						</c:forEach>
					</select>

				</div>



				<div>
					<button type="submit" class="btn btn-primary">Guardar</button>
					<a onclick="window.history.back();" class="btn btn-secondary"
						role="button">Cancelar</a>
				</div>
			</div>
		</form>
	</div>
	<jsp:include page="/partials/footer.jsp"></jsp:include>
</body>
</html>