<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigationPanel.jspf" %>


<body>
	<table class="table table-striped">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Salary</th>
			<th>action</th>
		</tr>
		<c:forEach items="${employee}" var="employee">
			<tr>
				<td>${employee.id}</td>
				<td>${employee.name}</td>
				<td>${employee.salary}</td>
				<td>
				<a class="button btn-success" href="/editEmployee?id=${employee.id}">Edit</a>
				<a class="button btn-danger" href="/deleteEmployee?id=${employee.id}" >delete</a></td>
				
			</tr>
		</c:forEach>
	</table>
	<a class="button btn-success" href="/addEmployee">Add</a>
	${name}		
	<br>${employee}	
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>