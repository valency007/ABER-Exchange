<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<meta http-equiv="refresh" content="90; URL=${pageContext.request.contextPath}/admin/list">
<title>Dashboard</title>
</head>
<body>

<style>


h1{
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}

/* -- import Roboto Font ---------------------------- */
@import "https://fonts.googleapis.com/css?family=Roboto:400,500, 300, 700, 100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic&subset=latin,cyrillic";

/* -- You can use this tables in Bootstrap (v3) projects. -- */
// @import "//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css";


/* -- Box model ------------------------------- */
*,
*:after,
*:before {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}

/* -- Demo style ------------------------------- */

body {
background: -webkit-linear-gradient(left, #25c481, #25b7c4);
  background: linear-gradient(to right, #25c481, #25b7c4);
  font-family: 'Roboto', sans-serif;

  // Font Rendering
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-rendering: optimizeLegibility;
}

#demo {
  margin: 20px auto;
  max-width: 960px;
}

.shadow-z-1 {
  -webkit-box-shadow: 0 1px 3px 0 rgba(0,0,0,.12),
                      0 1px 2px 0 rgba(0,0,0,.24);
  -moz-box-shadow:    0 1px 3px 0 rgba(0,0,0,.12),
                      0 1px 2px 0 rgba(0,0,0,.24);
  box-shadow:         0 1px 3px 0 rgba(0,0,0,.12),
                      0 1px 2px 0 rgba(0,0,0,.24);
}

@table-header-font-weight:      400;
@table-header-font-color:       #757575;

@table-cell-padding:            1.6rem;
@table-condensed-cell-padding:  @table-cell-padding/2;


@table-bg:                      #fff;
@table-bg-accent:               #f5f5f5;
@table-bg-hover:                rgba(0,0,0,.12);
@table-bg-active:               @table-bg-hover;
@table-border-color:            #e0e0e0;

.transition(@transition) {
  -webkit-transition: @transition;
       -o-transition: @transition;
          transition: @transition;
}

.table {
  width: 100%;
  max-width: 100%;
  margin-bottom: 2rem;
  background-color: @table-bg;
  > thead,
  > tbody,
  > tfoot {
    > tr {
      .transition(all .3s ease);
      > th,
      > td {
        text-align: left;
        padding: @table-cell-padding;
        vertical-align: top;
        border-top: 0;
        .transition(all .3s ease);
      }
    }
  }
  > thead > tr > th {
    font-weight: @table-header-font-weight;
    color: @table-header-font-color;
    vertical-align: bottom;
    border-bottom: 1px solid rgba(0,0,0,.12);
  }
  > caption + thead,
  > colgroup + thead,
  > thead:first-child {
    > tr:first-child {
      > th,
      > td {
        border-top: 0;
      }
    }
  }
  > tbody + tbody {
    border-top: 1px solid rgba(0,0,0,.12);
  }

  .table {
    background-color: @table-bg;
  }

  .no-border {
    border: 0;
  }
}

.table-condensed {
  > thead,
  > tbody,
  > tfoot {
    > tr {
      > th,
      > td {
        padding: @table-condensed-cell-padding;
      }
    }
  }
}

.table-bordered {
  border: 0;
  > thead,
  > tbody,
  > tfoot {
    > tr {
      > th,
      > td {
        border: 0;
        border-bottom: 1px solid @table-border-color;
      }
    }
  }
  > thead > tr {
    > th,
    > td {
      border-bottom-width: 2px;
    }
  }
}


.table-striped {
  > tbody > tr:nth-child(odd) {
    > td,
    > th {
      background-color: @table-bg-accent;
    }
  }
}

// Hover effect
//
.table-hover {
  > tbody > tr:hover {
    > td,
    > th {
      background-color: @table-bg-hover;
    }
  }
}

.table-responsive-vertical {

  @media screen and (max-width: 768px) {

    // Tighten up spacing
    > .table {
      margin-bottom: 0;
      background-color: transparent;
      > thead,
      > tfoot {
        display: none;
      }

      > tbody {
        display: block;

        > tr {
          display: block;
          border: 1px solid @table-border-color;
          border-radius: 2px;
          margin-bottom: @table-cell-padding;

          > td {
            background-color: @table-bg;
            display: block;
            vertical-align: middle;
            text-align: right;
          }
          > td[data-title]:before {
            content: attr(data-title);
            float: left;
            font-size: inherit;
            font-weight: @table-header-font-weight;
            color: @table-header-font-color;
          }
        }
      }
    }
    
    // Special overrides for shadows
    &.shadow-z-1 {
      -webkit-box-shadow: none;
      -moz-box-shadow: none;
      box-shadow: none;
      > .table > tbody > tr {
        border: none;
        .shadow-z-1();
      }
    }

    // Special overrides for the bordered tables
    > .table-bordered {
      border: 0;

      // Nuke the appropriate borders so that the parent can handle them
      > tbody {
        > tr {
          > td {
            border: 0;
            border-bottom: 1px solid @table-border-color;
          }
          > td:last-child {
            border-bottom: 0;
          }
        }
      }
    }

    // Special overrides for the striped tables
    > .table-striped {
      > tbody > tr > td,
      > tbody > tr:nth-child(odd) {
          background-color: @table-bg;
      }
      > tbody > tr > td:nth-child(odd) {
          background-color: @table-bg-accent;
      }
    }

    // Special overrides for hover tables
    > .table-hover {
      > tbody {
        > tr:hover > td,
        > tr:hover {
          background-color: @table-bg;
        }
        > tr > td:hover {
          background-color: @table-bg-hover;
        }
      }
    }
  }
}

.myButton {
	background-color:#FF5733;
	display:inline-block;
	cursor:pointer;
	color:#ffffff;
	font-family:Arial;
	font-size:16px;
	padding:7px;
	text-decoration:none;
}
.myButton:hover {
	background-color:#1D8348;
}
.myButton:active {
	position:relative;
	top:1px;
}


.table-striped.table-mc-blue > tbody > tr:nth-child(odd) > td,
.table-striped.table-mc-blue > tbody > tr:nth-child(odd) > th {
    background-color: #e7e9fd;
}
.table-hover.table-mc-blue > tbody > tr:hover > td,
.table-hover.table-mc-blue > tbody > tr:hover > th {
    background-color: #d0d9ff;
}
@media screen and (max-width: 767px) {
    .table-responsive-vertical .table-striped.table-mc-blue > tbody > tr > td,
    .table-responsive-vertical .table-striped.table-mc-blue > tbody > tr:nth-child(odd) {
        background-color: @table-bg;
    }
    .table-responsive-vertical .table-striped.table-mc-blue > tbody > tr > td:nth-child(odd) {
        background-color: #e7e9fd;
    }
    .table-responsive-vertical .table-hover.table-mc-blue > tbody > tr:hover > td,
    .table-responsive-vertical .table-hover.table-mc-blue > tbody > tr:hover {
        background-color: @table-bg;
    }
    .table-responsive-vertical .table-hover.table-mc-blue > tbody > tr > td:hover {
        background-color: #d0d9ff;
    }
}
.table-striped.table-mc-light-blue > tbody > tr:nth-child(odd) > td,
.table-striped.table-mc-light-blue > tbody > tr:nth-child(odd) > th {
    background-color: #e1f5fe;
}
.table-hover.table-mc-light-blue > tbody > tr:hover > td,
.table-hover.table-mc-light-blue > tbody > tr:hover > th {
    background-color: #b3e5fc;
}
@media screen and (max-width: 767px) {
    .table-responsive-vertical .table-striped.table-mc-light-blue > tbody > tr > td,
    .table-responsive-vertical .table-striped.table-mc-light-blue > tbody > tr:nth-child(odd) {
        background-color: @table-bg;
    }
    .table-responsive-vertical .table-striped.table-mc-light-blue > tbody > tr > td:nth-child(odd) {
        background-color: #e1f5fe;
    }
    .table-responsive-vertical .table-hover.table-mc-light-blue > tbody > tr:hover > td,
    .table-responsive-vertical .table-hover.table-mc-light-blue > tbody > tr:hover {
        background-color: @table-bg;
    }
    .table-responsive-vertical .table-hover.table-mc-light-blue > tbody > tr > td:hover {
        background-color: #b3e5fc;
    }
}


</style>

<script language="javascript">
function status(status){

if (status == "1") {
    document.write("Complete");
}
else{
	document.write("Incomplete");
}
}

function donation(donation){

	if (donation == "1") {
	    document.write("Yes");
	}
	else{
		document.write("No");
	}
	}
</script>

<h1 style = "text-align:center; ">Orders | <a style="display: inline-block; margin: 10px 0; vertical-align: middle;" href="${pageContext.request.contextPath}/admin/add" class="myButton">ADD <i class="fa fa-plus"></i></a></h1> 	
<h1 style = "text-align:center; ">${message}</h1>
<div class="table-responsive-vertical shadow-z-1">
<table id="table" class="table table-hover table-mc-light-blue" style = "background-color: #fffde7;" cellspacing = 0>
<thead style="background-color: wheat;">
<tr>
<th width="5%">Order ID</th><th width="10%">Name</th><th width="10%">Email Address</th><th width="10%">Phone Number</th><th width="10%">Source Address</th><th width="10%">Destination Address</th><th width="10%">Notes</th><th width="5%">Donation</th><th width="10%">Rider</th><th width="10%">Status</th><th width="10%">Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="order" items="${orders}">

<tr style="padding-top: 2px;">
	<td style="text-align:center;">${order.id}</td>
	<td>${order.name}</td>
	<td>${order.email}</td>
	<td style="text-align:center;">${order.cnumber}</td>
	<td>${order.s_address}</td>
	<td>${order.d_address}</td>
	<td>${order.notes}</td>
	<td style="text-align:center;"><script>donation(${order.isDonation});</script></td>
	<td>${order.rider}</td>
	<td style="text-align:center;"><script>status(${order.status});</script></td>
	<td style="text-align:center;">
	<a href="${pageContext.request.contextPath}/admin/edit/${order.id}.html"><i class="fa fa-gears" style="font-size:34px; color:#283747;"></i></a>   
	<a href="${pageContext.request.contextPath}/admin/delete/${order.id}.html"><i class="fa fa-trash-o" style="font-size:36px; color:red;"></i></i></a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>


<h1 style = "text-align:center; ">Credit Redemption History | <a style="display: inline-block; margin: 10px 0; vertical-align: middle;" href="${pageContext.request.contextPath}/admin/credit/add" class="myButton">ADD <i class="fa fa-plus"></i></a></h1> 	
<div class="table-responsive-vertical shadow-z-1">
<table id="table" class="table table-hover table-mc-light-blue" style = "background-color: #fffde7;" cellspacing = 0>
<thead style="background-color: wheat;">
<tr>
<th width="5%">ID</th><th width="30%">Customer Email</th><th width="25%">Credit Usage</th><th width="30%">Reward</th><th width="10%">Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="credit" items="${credits}">

<tr>
	<td style="text-align:center;">${credit.cid}</td>
	<td style="text-align:center;">${credit.cemail}</td>
	<td style="text-align:center;">${credit.credit_use}</td>
	<td style="text-align:center;">${credit.reward}</td>
	<td style="text-align:center;">
	<a href="${pageContext.request.contextPath}/admin/credit/edit/${credit.cid}.html" ><i class="fa fa-gears" style="font-size:34px; color:#283747;"></i></a>
	<a href="${pageContext.request.contextPath}/admin/credit/delete/${credit.cid}.html"><i class="fa fa-trash-o" style="font-size:36px; color:red;"></i></a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>


<h1 style = "text-align:center; ">Users | <a style="display: inline-block; margin: 10px 0; vertical-align: middle;" href="${pageContext.request.contextPath}/admin/user/add" class="myButton">ADD <i class="fa fa-plus"></i></a></h1> 	
<div class="table-responsive-vertical shadow-z-1">
<table id="table" class="table table-hover table-mc-light-blue" style = "background-color: #fffde7;" cellspacing = 0>
<thead style="background-color: wheat;">
<tr>
<th width="5%">ID</th><th width="15%">First Name</th><th width="15%">Last Name</th><th width="15%">Email</th><th width="15%">Password</th><th width="15%">Contact Number</th><th width="10%">Credits</th><th width="10%">Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="user" items="${users}">

<tr>
	<td style="text-align:center;">${user.uid}</td>
	<td style="text-align:center;">${user.fname}</td>
	<td style="text-align:center;">${user.lname}</td>
	<td style="text-align:center;">${user.email}</td>
	<td style="text-align:center;">${user.password}</td>
	<td style="text-align:center;">${user.contact_number}</td>
	<td style="text-align:center;">${user.credit}</td>
	<td style="text-align:center;">
	<a href="${pageContext.request.contextPath}/admin/user/edit/${user.uid}.html" ><i class="fa fa-gears" style="font-size:34px; color:#283747;"></i></a>
	<a href="${pageContext.request.contextPath}/admin/user/delete/${user.uid}.html"><i class="fa fa-trash-o" style="font-size:36px; color:red;"></i></a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

<h1 style = "text-align:center; ">Riders | <a style="display: inline-block; margin: 10px 0; vertical-align: middle;" href="${pageContext.request.contextPath}/admin/rider/add" class="myButton">ADD <i class="fa fa-plus"></i></a></h1> 
<div class="table-responsive-vertical shadow-z-1">
<table id="table" class="table table-hover table-mc-light-blue" style = "background-color: #fffde7;" cellspacing = 0>
<thead style="background-color: wheat;">
<tr>
<th width="5%">ID</th><th width="45%">Email</th><th width="40%">Password</th><th width="10%">Actions</th>
</tr>
</thead>
<tbody>
<c:forEach var="rider" items="${riders}">

<tr>
	<td style="text-align:center;">${rider.id}</td>
	<td style="text-align:center;">${rider.email}</td>
	<td style="text-align:center;">${rider.password}</td>
	<td style="text-align:center;">
	<a href="${pageContext.request.contextPath}/admin/rider/edit/${rider.id}.html" ><i class="fa fa-gears" style="font-size:34px; color:#283747;"></i></a>
	<a href="${pageContext.request.contextPath}/admin/rider/delete/${rider.id}.html" ><i class="fa fa-trash-o" style="font-size:36px; color:red;"></i></a><br/>
	</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>

<h1 style = "text-align:center;">Realtime Rider Location</h1>
<div class="table-responsive-vertical shadow-z-1">
<table id="table" class="table table-hover table-mc-light-blue" style = "background-color: #fffde7;" cellspacing = 0>
<thead style="background-color: wheat;">
<tr>
<th width="30%">Email</th><th width="30%">Latitude</th><th width="30%">Longitude</th><th width="10%">Live Tracking</th>
</tr>
</thead>
<tbody>
<c:forEach var="location" items="${locations}">

<tr>
	<td style="text-align:center;">${location.email}</td>
	<td style="text-align:center;">${location.lat}</td>
	<td style="text-align:center;">${location.lon}</td>
	<td style="text-align:center;">
	<a href="http://maps.google.com/maps?q=${location.lat},${location.lon}" target="_blank"><i class="fa fa-location-arrow" style="font-size:34px; color:#283747;"></i></a>
	
	</td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
<br/>
<h1 style = "text-align:center; ">List of Products | <a style="display: inline-block; margin: 10px 0; vertical-align: middle;" href="${pageContext.request.contextPath}/admin/products" class="myButton">Database <i class="fa fa-external-link"></i></a></h1> 
<br/>

<p style="text-align:center; color:white;">Made with <i class="fa fa-heart" style="color:red;"></i> for the University of Sydney<br/>Credits include the creative heads at Codepen.io and the Techies at Stackoverflow.com</p>
<br/>
</body>
</html>