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
             Assigned Alerts
            </p>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(document).ready(function () {
   $("#operations_group").change(function() {
	   //alert("inside");
		var ops_group = $(this).val();
		//alert(ops_group);
		$.post('/casem/viewopsList', {
			ops_group : ops_group
		}, function(data) {
			$('#loadoperationsInfo').html(data)
		});
	})
	
});
</script>
<div class="form-group row">
	<div class="col-md-3">
		<label>Operations Group <span style="color:red">*</span></label> 
	</div>
	<div class="col-md-9">
	<select name="operations_group" id="operations_group" class="form-control form-control1">
		<option value="" selected disabled>Select operations group..</option>
		<c:forEach items="${viewOPSID}" var="opsId">
			<option value="${opsId}">${opsId}</option>
		</c:forEach>
	</select>
	</div>
</div>
	<br>
	<div id="loadoperationsInfo"></div>
	 </div></div></div></div> 
<jsp:include page="../cdg_footer.jsp" />