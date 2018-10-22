<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ page import="javax.servlet.http.*"%>

<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Case Management Home</title>
  <!-- plugins:css -->
  <link rel="stylesheet" href="/assets/iconfonts/mdi/css/materialdesignicons.min.css">
  <link rel="stylesheet" href="/assets/css/vendor.bundle.base.css">
  <!-- endinject -->
  <!-- inject:css -->
  <link rel="stylesheet" href="/assets/css/style2.css">
  <!-- endinject -->
  <link rel="shortcut icon" href="/assets/img/favicon.ico" />
  <!-- Include multi.js -->
  <link rel="stylesheet" type="text/css" href="../assets/css/multi.min.css">
  <script src="../assets/js/multi.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script type="text/javascript">
  function tog(ids)
  {
	  if(ids=="max")
	{
	  document.getElementById("min").style.display="block";
	  document.getElementById("max").style.display="none";
	}
	  if(ids=="min")
	{
		document.getElementById("max").style.display="block";
		document.getElementById("min").style.display="none";
	}
  }
  function multisel(src_id,tgt_id)
  {
		var el = document.getElementById(src_id);
		var result = "";
		var options = el.options;
		var opt;
		for (var i = 0, iLen = options.length; i < iLen; i++) {
			opt = options[i];
			if (opt.selected) {
				if(opt.value==="*")
				{
					result="";
					for (var j = 0, jLen = options.length; j < jLen; j++) {
						opt1 = options[j];
						if(opt1.value!="*")
						{
							result=result+","+opt1.value;
						}
					}
					break;
				}
				else
				{
					result=result+","+opt.value;
				}
			}
		}
		result=result.substring(1);
		document.getElementById(tgt_id).value=result;
  }
  
  
  
  
  $(document).ready(function() {
	
		 $("#projects").change(function() {

				var project = $(this).val();
	
				 $.post('/login/features', {
					project : project
				}, function(data) {
					//alert(data);
					
					window.location.href="/login/dashboard";
				}); 
	 
		}); 
	  
  });
  
  </script>
   <style>
.cust {
  width:95%;
  margin:5px;
  padding:0.875rem 0.5rem;
}
  
.row1 {
  display: flex;
  flex-wrap: wrap;
  padding: 0 4px;
}

/* Create four equal columns that sits next to each other */
.column1,.column2 {
  flex: 16.66%;
  max-width: 16.66%;
  padding: 0 5px;
}

.column1 img {
  margin-top: 8px;
  vertical-align: middle;
  width: 150px;
  height: 175px;
  border: 1px solid black;
}
.column2 img {
  margin-top: 8px;
  vertical-align: middle;
  width: 150px;
  border: 1px solid black;
}
/* Responsive layout - makes a two column-layout instead of four columns */
@media screen and (max-width: 800px) {
  .column1,.column2 {
    flex: 50%;
    max-width: 50%;
  }
}
/* Responsive layout - makes the two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 600px) {
  .column1,.column2{
    flex: 100%;
    max-width: 100%;
  }
}
#bgDiv {
  position:fixed;
  top:0px;
  bottom:0px;
  left:260px;
  right:0px;
  overflow:hidden;
  padding:0;
  margin:0;
  background-color:white;
  filter:alpha(opacity=25);
  opacity:0.25;
  z-index:1000;
}

.fs {
  border:1px groove #DCDCDC;
  padding:10px;
  margin:10px;
  border-radius:10px;
}
.leg {
  font-size:0.8em;
  font-weight:bold;
}
</style>
</head>
<body>
  <div class="container-scroller">
    <!-- partial:partials/_navbar.html -->
    <nav class="navbar default-layout-navbar col-lg-10 col-7 p-0 fixed-top d-flex flex-row">
      <div class="text-center navbar-brand-wrapper d-flex align-items-center justify-content-center">
       <a class="navbar-brand brand-logo" href="/"><img src="/assets/img/download.jpg" alt="logo"/></a>
        <a class="navbar-brand brand-logo-mini" href="/"><img src="/assets/img/download.jpg" alt="logo"/>}</a>
   
      </div>
      <div class="navbar-menu-wrapper d-flex align-items-stretch">
      	<div class="navbar-nav navbar-nav-left">
			<select class="form-control"
					id="projects" name="projects">
					  <%
							if (session.getAttribute("project") != null) {
						%>
						<option value="${project}" selected>${project}</option>
						<%
							}else{
						%>
					<option value="" selected>Project ...</option>
					<%
							}
					%>
					<c:forEach items="${arrProject}" var="arrProject">
						<option value="${arrProject.project_id}">${arrProject.project_id}</option>
					</c:forEach>
				</select>

        </div>
        <ul class="navbar-nav navbar-nav-right">
          <li class="nav-item nav-profile dropdown">
            <a class="nav-link dropdown-toggle" id="profileDropdown" href="#" data-toggle="dropdown" aria-expanded="false">
              <div class="nav-profile-img">
              
           <c:choose>
			    <c:when test="${user.user_id=='admin'}"><img src="/assets/img/faces/jiten.jpg" alt="image"></c:when>
			    <c:when test="${user.user_id=='vaibhav'}"><img src="/assets/img/faces/face.png" alt="image"></c:when>
			    <c:when test="${user.user_id=='abhishek'}"><img src="/assets/img/faces/face.png" alt="image"></c:when>
			    <c:when test="${user.user_id=='test'}"><img src="/assets/img/faces/face.png" alt="image"></c:when>
			    <c:otherwise><img src="/assets/img/faces/face.png" alt="image"></c:otherwise>
			</c:choose>
			 
                <span class="availability-status online"></span>             
              </div>
              <div class="nav-profile-text">
                <p class="mb-1 text-black">${user.user_id}</p>
              </div>
            </a>
            <div class="dropdown-menu navbar-dropdown" aria-labelledby="profileDropdown">
              <a class="dropdown-item" href="#">
                <i class="mdi mdi-account-circle mr-2 text-success"></i>
                Profile
              </a>
              <div class="dropdown-divider"></div>
             <a class="dropdown-item" href="/logout">
                <i class="mdi mdi-logout mr-2 text-primary"></i>
                Logout
              </a>
            </div>
          </li>
          <li class="nav-item d-none d-lg-block full-screen-link">
            <a class="nav-link">
              <i class="mdi mdi-fullscreen" id="fullscreen-button"></i>
            </a>
          </li>
          <li class="nav-item nav-logout d-none d-lg-block">
           <a class="nav-link" href="/logout">
              <i class="mdi mdi-power"></i>
            </a> 
          </li>
        </ul>
        <button class="navbar-toggler navbar-toggler-right d-lg-none align-self-center" type="button" data-toggle="offcanvas">
          <span class="mdi mdi-menu"></span>
        </button>
      </div>
    </nav>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
      <!-- partial:partials/_sidebar.html -->
      <nav class="sidebar sidebar-offcanvas" id="sidebar">
        <ul class="nav">
          <li class="nav-item nav-profile">
            <a href="#" class="nav-link">
              <div class="nav-profile-image">
                <c:choose>
			   <c:when test="${user.user_id=='admin'}"><img src="/assets/img/faces/jiten.jpg" alt="image"></c:when>
			    <c:when test="${user.user_id=='vaibhav'}"><img src="/assets/img/faces/face.png" alt="image"></c:when>
			    <c:when test="${user.user_id=='abhishek'}"><img src="/assets/img/faces/face.png" alt="image"></c:when>
			    <c:when test="${user.user_id=='test'}"><img src="/assets/img/faces/face.png" alt="image"></c:when>
			    <c:otherwise><img src="/assets/img/faces/face.png" alt="image"></c:otherwise>
			</c:choose>
                <span class="login-status online"></span> <!--change to offline or busy as needed-->              
              </div>
              <div class="nav-profile-text d-flex flex-column">
                <span class="font-weight-bold mb-2">${user.user_id}</span>
                <span class="text-secondary text-small">Application User</span>
              </div>
              <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
            </a>
         
          
			<!-- <div id="menu"> -->
		
				<li class="nav-item"> <a class="nav-link" data-toggle="collapse" href="#casem" aria-expanded="false" aria-controls="casem"> <span class="menu-title">Case Management</span> <i class="menu-arrow"></i> <i class="mdi mdi-account-settings-variant menu-icon"></i> </a> 
						<div class="collapse" id="casem"> 
							<ul class="nav flex-column sub-menu"> 
								<li class="nav-item"> <a class="nav-link" href="/casem/viewAlerts">Assign Cases</a></li> 
								<!--<li class="nav-item"> <a class="nav-link" href="/casem/OperationsView">Operations View</a></li>-->
								<li class="nav-item"> <a class="nav-link" href="/casem/Level-1Investigation">Level-1 Investigation </a></li>
							</ul>
						</div>
					</li>
				<!-- </div> -->
        </ul>
      </nav>
