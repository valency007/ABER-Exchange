<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
	</head>
	<body>
		<h1>
			<fmt:message key="heading" />s
			<a href="<c:url value="/hello.htm"/>">Home</a>
			
		</h1>
		<p>
			<fmt:message key="greeting" />
		</p>
		
		<form action="search" method="get">
			<input type="text" name="description">
			<input type="submit" value="Search"/><br>
		</form>
		
		<h3>Products</h3>
		<c:forEach items="${lists}" var="prod">
			<tr>
				<td><c:out value="${prod.description}" /></td>
				<td>$<c:out value="${prod.price}" /></td>
				<td><c:out value="${prod.image}" /></td>
				<td><img src="product/showPic/${prod.image}" style="width:auto; height: 20%;"/></td>
			</tr>
		</c:forEach>
	</body>
</html>