<%@ include file="/WEB-INF/views/include.jsp"%>
<html>
	<head>
		<title><fmt:message key="title" /></title>
	</head>
	<body>
		<h1>
			<fmt:message key="heading" />
			<a href="<c:url value="hello.htm"/>">Home</a>
		</h1>
		<p>
			<fmt:message key="greeting" />
			<c:out value="${model.now}" />
		</p>
		
		<form action="product/search" method="get">
			<input type="text" name="description">
			<input type="submit" value="Search"/><br>
		</form>
		
		<h3>Products</h3>
		<c:forEach items="${model.products}" var="prod">
			<tr>
				<a href="showItem.htm"><td><c:out value="${prod.description}" /></td></a>
				<td>$<c:out value="${prod.price}" /></td><br/>
				<!-- <td><c:out value="${prod.image}" /></td> -->
				<a href="showItem.htm"><td><img src="product/showPic/${prod.image}" style="width:auto; height: 20%;"/></td></a><br/>
			</tr>
			<!--  
				<c:out value="${prod.description}" />
				<i>$<c:out value="${prod.price}" /></i>
				<i><c:out value="${prod.image}" /></i>
				<i><img src="product/showPic/${prod.image}" style="width:auto; height: 20%;"/></i>
			<a href="product/edit/${prod.id }">edit</a>
			<a href="product/delete/${prod.id }">delete</a>
			<br>
			<br>-->
		</c:forEach>
	
		<!-- link to the increase price page -->
		<br>
		<a href="<c:url value="/priceincrease.htm"/>">Increase Prices</a>
		<br>
	</body>
</html>