<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../partials/nav.jsp"></jsp:include>
	<jsp:include page="../partials/dataTable.jsp"></jsp:include>

	<div class="col-lg-6 mx-auto py-md-3">
		<c:if test="${user.isAdmin()}">
		</c:if>
		<table id="dataTable" class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Admin</th>
					<th>pass</th>
					<th>Presupuesto</th>
					<th>Tiempo</th>
					<th>Preferencia</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allUsers}" var="anUser">
					<tr>
						<td><strong><c:out value="${anUser.nombre}"></c:out></strong></td>
						<td><c:out value="${anUser.isAdmin()}"></c:out></td>
						<td><c:out value="****"></c:out></td>
						<td><c:out value="${anUser.presupuesto}"></c:out></td>
						<td><c:out value="${anUser.tiempoDisponible}"></c:out></td>
						<td><c:out value="${anUser.tipoAtraccionPreferida}"></c:out></td>

						<td><c:if test="${user.isAdmin()}">
								<a href="EditarUsuario.do?userId=${anUser.id}"
									class="btn btn-info rounded" role="button" title="Editar"><i
									class="bi bi-pencil-fill"></i></a>
								<a href="deleteUser.do?userId=${anUser.id}"
									class="btn btn-danger rounded" role="button" title="Eliminar"><i
									class="bi bi-x-circle-fill"></i></a>
							</c:if> 
							</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>

	<jsp:include page="/partials/footer.jsp"></jsp:include>


</body>
</html>