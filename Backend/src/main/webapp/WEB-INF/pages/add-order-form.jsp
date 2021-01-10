<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Add order page</title>
</head>
<style>

* { box-sizing: border-box; }

html,
body {
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  
}

body {
  font-family: 'Economica', 'Arial', sans-serif;
  font-size: 18px;
  background: #35dc9b;
}

h1 {
  display: table;
  margin: 40px auto;
  color: #fff;
  font: 20px Helvetica;
  text-transform: uppercase;
  letter-spacing: 3px;
  }

.container {
  position: relative;
  width: 80%;
  max-width: 450px;
  margin: 0 auto;
}

form {
  position: relative;
  width: 100%;
  margin: 50px auto;
  padding: 50px;
  background: white;
  text-align: center;
}

input {
  display: inline-block;
  width: 100%;
  margin: 20px 0;
  padding: 10px;
  border: 2px dashed lightblue;
  outline: none;
  font-size: 20px;
  font-family: 'Economica', 'Arial', sans-serif;
  font-weight: 400;
  transition: all 0.2s ease;
}

input:focus { border-color: deepskyblue; }

button {
  position: absolute;
  left: calc(50% - 150px / 2);
  bottom: calc(- 50px / 2);
  width: 150px;
  height: 50px;
  padding: 10px 15px;
  margin-top: 20px;
  border: none;
  outline: none;
  cursor: pointer;
  color: white;
  font-family: 'Economica', 'Arial', sans-serif;
  font-size: 20px;
  font-weight: 700;
  background: mediumblue;
  transition: all 0.2s ease;
}

button:hover { background: blue; }

button.valid,
button.valid:hover { background: green; }

svg {
  position: absolute;
  top: 0;
  left: 0;
  pointer-events: none;
}

svg path {
  stroke-width: 10px;
  stroke: mediumseagreen;
  fill: none;
  opacity: 1;
  transition: opacity 0.5s ease;
}

td{
font-size: 20px;
  font-family: 'Economica', 'Arial', sans-serif;
  font-weight: 400;

}

svg path.hidden { opacity: 0; }

svg path.animate { animation: drawBorder 1s linear; }

@keyframes drawBorder {
  from {
    stroke-dasharray: 4000;
    stroke-dashoffset: 4000;
  }
  
  to {
    stroke-dasharray: 4000;
    stroke-dashoffset: 0;
  }
}

h3 {
  margin-top: 0;
  margin-bottom: 20px;
  text-transform: uppercase;
  font-size: 24px;
  font-weight: 700;
}

</style>





<body>
<h1 style="text-align:center;">Add New Order</h1>
<div class="container">
<form:form method="POST" commandName="order" action="${pageContext.request.contextPath}/admin/add.html">
<form:input path="name" placeholder="Name"/>
		<form:input path="email" placeholder="Email"/>
		<form:input path="cnumber" placeholder="Phone Number"/>
		<form:input path="s_address" placeholder="Source Address"/>
		<form:input path="d_address" placeholder="Destination Address"/>
		<form:input path="notes" placeholder="Additional Notes"/>
		<form:input path="isDonation" placeholder="Donation: Y(1) or N(0)" />
		<form:input path="rider" value="UNASSIGNED" placeholder="UNASSIGNED - Default"/>
		<form:input path="status" value="0" placeholder="Status: Done(1) or Pending(0)"/>
		<input type="submit" value="ADD"  />
</form:form>
</div>


</body>
</html>