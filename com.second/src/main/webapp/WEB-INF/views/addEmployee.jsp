<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigationPanel.jspf" %>

<body>

	<form:form action="/addEmployee" method="POST" commandName="employee">

		<div>
			<form:label path="id">ID:</form:label>
			<form:input path="id" type="number"/>
			<form:errors path="id" cssStyle="text-warning" />
		</div>
		<div>
			<form:label path="name">NAME:</form:label>
			<form:input path="name" type="text" />
			<form:errors path="name" cssStyle="text-warning" />
		</div>
		<div>
			<form:label path="salary">SALARY:</form:label>
			<form:input path="salary"  type="number"/>
			<form:errors path="salary" cssStyle="text-warning" />
		</div>
		<div>
			<input type="submit" />
		</div>
	</form:form>
	<%@ include file="common/footer.jspf" %>
	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>