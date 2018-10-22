<jsp:include page="../cdg_header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="main-panel">
<div class="content-wrapper">
<div class="row">
   <div class="col-12 grid-margin stretch-card">
      <div class="card">
         <div class="card-body">
            <h4 class="card-title">Case Management</h4>
            <p class="card-description">
               Assign Cases
            </p>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(document).ready(function () {
   $("#src_sys_id").change(function() {
	   //alert("inside");
		var sys_id = $(this).val();
		//alert(sys_id);
		$.post('/casem/viewCtryList', {
			sys_id : sys_id
		}, function(data) {
			$('#loadCountryInfo').html(data)
		});
	})
	
});
</script>
<div class="form-group row">
	<div class="col-md-3">
		<label>System Name<span style="color:red">*</span></label> 
	</div>
	<div class="col-md-9">
	<select name="src_sys_id" id="src_sys_id" class="form-control form-control1">
		<option value="" selected disabled>Select system name..</option>
		<c:forEach items="${viewSSID}" var="fileId">
			<option value="${fileId}">${fileId}</option>
		</c:forEach>
	</select>
	</div>
</div>
	<br>
	<div id="loadCountryInfo"></div>
	 </div></div></div></div> 
<jsp:include page="../cdg_footer.jsp" />