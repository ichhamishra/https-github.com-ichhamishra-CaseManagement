<jsp:include page="../cdg_header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="main-panel">
<div class="content-wrapper">
<div class="row">
   <div class="col-12 grid-margin stretch-card">
 <form class="forms-sample" id="extractionExtractData" name="extractionExtractData" method="POST" action="/casem/viewsubmit2">
      <div class="card">
         <div class="card-body">
            
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	
						  <div class="form-group row">

						 <div class="col-md-3">
		<label>Comments<span style="color:red">*</span></label> 
	</div>
						  <input type="text" class="form-control" id="Comment" name="Comment" placeholder="Comment" width="25em";  height:"2em"; >
					
                         <br>
                           <br>
                           
                           
                          <div class="col-md-3">
                          <br>
		<label>Alert id<span style="color:red">*</span></label> 
	</div>
						  <input type="text" class="form-control" id="Comment" name="alert_id" placeholder="alert_id" width="25em";  height:"2em"; >
                           <br>
                           <br>
                           
                          <div class="col-md-3">
                          <br>
		<label>User name <span style="color:red">*</span></label> 
	</div>
						  <input type="text" class="form-control" id="Comment" name="user_name" placeholder="user_name" width="25em";  height:"2em"; >
                           <div>
                           <br></br>
						  <button id="save" name="save" type="submit" class="btn btn-rounded btn-gradient-info mr-2">Save</button>
			
					</div>
					</div>
					</form>
						
						</div>
						</div>
						</div>
						</div>