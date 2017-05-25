<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Contacts Directory</title>
		
		<link type="text/css"
			  rel="stylesheet"
			  href="${pageContext.request.contextPath}/resources/css/style.css"/>
	</head>
	
	<body>
		<input type="button" onclick="window.location.href='showFormForAdd'" value="Add Contact" class="add-button"/>
		
		<table>
			<tr>
				<th>Name</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Address</th>
				<th>Action</th>
				
			</tr>
			<c:forEach var="tempContact" items="${contacts }">
				<c:url var="updateLink" value="/contact/showFormForUpdate">
					<c:param name="contactId" value="${tempContact.id }" />
				</c:url>
				<c:url var="deleteLink" value="/contact/delete">
					<c:param name="contactId" value="${tempContact.id }" />
				</c:url>
				
				<tr>
					<td>${tempContact.name }</td>
					<td>${tempContact.email }</td>
					<td class="mobile">${tempContact.mobile}</td>
					<td>${tempContact.address }</td>
					<td><a href="${updateLink }">Update</a>
					|
					<a href="${deleteLink }" onclick="if(!(confirm('Are you sure you want to delete this contact?')))return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<script src="${pageContext.request.contextPath}/resources/js/US-Phone-Format.js" type="text/javascript"></script>
	</body>
</html>