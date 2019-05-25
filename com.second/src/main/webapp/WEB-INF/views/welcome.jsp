<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigationPanel.jspf" %>


 	
    <body> 
    welcome ${name}
    <spring:message code="employee.code"></spring:message>
    <a href="/showEmployee">click to see list of Employees</a>   
    <%@include file="common/footer.jspf" %>
    </body>
</html>
