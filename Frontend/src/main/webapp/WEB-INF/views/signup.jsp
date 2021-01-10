<%@ include file="/WEB-INF/views/include.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>
<head>
<title><fmt:message key="title" /></title>
<style>
.error {color: red;}
</style>
</head>
<body>
	<h1>Sign Up</h1>
	<form:form method="post" commandName="signUp">
		<table width="100%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
			<tr>
				<td align="right" width="20%">First name:</td>
				<td width="20%">
					<form:input path="fname" />
				</td>
				<td width="60%">
					<form:errors path="fname" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td align="right" width="20%">Last name:</td>
				<td width="20%">
					<form:input path="lname" />
				</td>
				<td width="60%">
					<form:errors path="lname" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td align="right" width="20%">Email :</td>
				<td width="20%">
					<form:input path="email" />
				</td>
				<td width="60%">
					<form:errors path="email" cssClass="error" />
				</td>
			</tr>
			<tr>
				<td align="right" width="20%">Password:</td>
				<td width="20%">
					<form:password path="password" />
				</td>
				<td width="60%">
					<form:errors path="password" cssClass="error" />
				</td>
			</tr>
		</table>
		<br>
		<input type="submit" align="center" value="Sign Up">
	</form:form>
	<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>