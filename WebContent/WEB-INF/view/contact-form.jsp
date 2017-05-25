<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Contact Entry Form</title>
		
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css"/>
			  
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css"/>
			  
		<style>.error{color:red; 
						display:block;}
		</style>
	</head>
	
	<body>
		<form:form action="saveContact" modelAttribute="contact" method="POST">
			<form:hidden path="id"/>
				<table>
					<tbody>
						<tr>
							<td> <label>Name</label> </td>
							<td> <form:input path="name"/> </td>
							<form:errors path="name" class="error"  />
						</tr>
						<tr>
							<td> <label>Email</label> </td>
							<td> <form:input path="email"/> </td>
							<form:errors path="email" class="error"  />
						</tr>
						<tr>
							<td> <label>Mobile</label> </td>
							<td> <form:input path="mobile"/> </td>
						</tr>
						<tr>
							<td> <label>Address</label> </td>
							<td> <form:input path="address"/> </td>
						</tr>
						<tr>
							<td> <input type="submit" value="Save" class="save" /> </td>
						</tr>
					</tbody>
				</table>
		</form:form>
		
		<a href="${pageContext.request.contextPath}/contact/list">Back to List</a>
	</body>
</html>