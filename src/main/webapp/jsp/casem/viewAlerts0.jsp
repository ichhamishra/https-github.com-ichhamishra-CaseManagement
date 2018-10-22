<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script>
$(document).ready(function () {
   $("#ctry_id").change(function() {
		var ctry_id = $(this).val();
		var sys_id=document.getElementById('sys_id').value;
		$.post('/casem/viewAlertTable', {
			sys_id : sys_id,
			ctry_id : ctry_id
		}, function(data) {
			$('#loadAlertTable').html(data)
		});
	})
	
});
</script>
<input type="hidden" name="sys_id" id="sys_id" value="${sys_id}">
<div class="form-group row">
	<div class="col-md-3">
		<label>Country Code<span style="color:red">*</span></label> 
	</div>
	<div class="col-md-9">
	<select name="ctry_id" id="ctry_id" class="form-control form-control1">
		<option value="" selected disabled>Select country code..</option>
		<c:forEach items="${countryList}" var="country">
			<option value="${country}">${country}</option>
		</c:forEach>
	</select>
	</div>
</div>
	<br>
	<div id="loadAlertTable"></div>
	