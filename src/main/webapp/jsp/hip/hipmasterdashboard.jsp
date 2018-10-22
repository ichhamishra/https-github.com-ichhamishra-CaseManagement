<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
<meta charset="utf-8" />
<!--<link rel="apple-touch-icon" sizes="76x76" href="./material/img/apple-icon.png">
  <link rel="icon" type="image/png" href="./material/img/favicon.png"> -->
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Feed Master Dashboard</title>
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no'
	name='viewport' />
<!--     Fonts and icons     -->
<!--<link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css">-->
<!-- CSS Files -->
<link href="../../material/css/material-kit.css?v=2.0.4"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="../../material/demo/demo.css" rel="stylesheet" />
<link rel="stylesheet"
	href="../../assets/iconfonts/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="../../assets/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- inject:css -->
<link rel="stylesheet" href="../../assets/css/style2.css">
<!-- endinject -->
<link rel="shortcut icon" href="../../assets/img/favicon.ico" />
<!-- Include multi.js -->
<link rel="stylesheet" type="text/css"
	href="../../assets/css/multi.min.css">
<script src="../../assets/js/multi.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#feedIdFilter").change(function() {
			var feed_id = $(this).val();
			$.post('/hip/hipmasterdashboard1', {
				feed_id : feed_id
			}, function(data) {
				$('#datdyn').html(data)
			});
		});
	});
</script>
</head>
<body class="profile-page sidebar-collapse" data-parallax="true"
	style="background-image: url('./material/img/city-profile.jpg');">
	<div class="page-header header-filter" style="height: 100px;"></div>
	<div class="main main-raised">
		<div class="profile-content">
			<div class="container">
				<div class="tab-content tab-space">
					<div class="tab-pane active text-center gallery" id="studio">
					  <div class="row">
          <div class="mt-3" align="left">
                	<a href="/">Home</a>
                </div>
          </div>
						<div class="row">
							<div class="card-body">
								<h2 class="card-title"  align="left">Feed Master Dashboard</h2>
										<div class="row">
											<div class="col-md-4">
												<div class="form-group">
													<h4 class="card-title" align="left">Select Feed</h4> <select class="form-control"
														id="feedIdFilter" name="feedIdFilter">
														<option value="" selected disabled>Select Feed
															...</option>
														<c:forEach items="${feed_id}" var="feed_id">
															<option value="${feed_id}">${feed_id}</option>
														</c:forEach>
													</select>
												</div>
											</div>
										</div>
										<div id="datdyn">
										</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!--   Core JS Files   -->
	<!-- <script src="../../material/js/core/jquery.min.js" type="text/javascript"></script> -->
	<script src="../../material/js/core/popper.min.js"
		type="text/javascript"></script>
	<script src="../../material/js/core/bootstrap-material-design.min.js"
		type="text/javascript"></script>
	<script src="../../material/js/plugins/moment.min.js"></script>
	<!-- Control Center for Material Kit: parallax effects, scripts for the example pages etc -->
	<!--   <script src="../../material/js/material-kit.js?v=2.0.4" type="text/javascript"></script> -->
	<script src="../../assets/js/vendor.bundle.base.js"></script>
	<script src="../../assets/js/vendor.bundle.addons.js"></script>
	<script src="../../assets/js/off-canvas.js"></script>
	<script src="../../assets/js/misc.js"></script>
	<script src="../../assets/js/dashboard.js"></script>
</body>
</html>