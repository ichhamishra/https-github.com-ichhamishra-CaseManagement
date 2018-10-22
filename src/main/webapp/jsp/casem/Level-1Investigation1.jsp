<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <div class="row">
<div class="form-group col-md-12 ">

<form class="forms-sample" id="extractionExtractData" name="extractionExtractData" method="POST" action="/casem/viewsubmit1">						

<div id="allvalues" style="display: block;">
<div style="overflow-x:auto;">

     <table class="table table-bordered" id="feedId1">
 <thead>
                      <tr style="color: green;;font: bolder;">
                      
                      <th style="">
                          Alert Id
                        </th>
                        <th>
                          Employee Id
                        </th>
                        <th>
                          Employee Name
                        </th>
                    	<th>
                          dateGE
                          </th>
						<th>
                        Justification
                        </th>
				
						<th>
                        Authorising Manager
                       </th>
                       <th>
                        Status
                       </th>
                        <th>
                        Assigned user
                        </th>
                        <th>
                        Assignee Name
                        </th>
                      </tr>
                    </thead>
                    <tbody>
                   
	                   <c:forEach items="${tableList}" var="opsdetail">
	                   <input type="hidden" name="alert_id" id="alert_id" value="${opsdetail.getAlertId()}">
						<tr class="table-default">
							<td><a href="/CaseManagement/Assigneedetail"><div style="height:100%;width:100%">${opsdetail.getAlertId()}</td>
							<td>${opsdetail.getEmployeeId()}</td>
							<td>${opsdetail.getEmployeeName()}</td>
							<td>${opsdetail.getDateGE()}</td>
							<td>${opsdetail.getJustification()}</td>
							<td>${opsdetail.getAuthorisingManager()}</td>
							<td>${opsdetail.getStatus()}</td>
							 <td>${opsdetail.getAssigneegroup()}</td>
							 <td style="width:150px">
											<select name="user_name" id="user_name" class="form-control form-control1">
		<option value="" selected disabled>Select user name..</option>
		<c:forEach items="${getuserList}" var="fileId">
			<option value="${fileId}">${fileId}</option>
			</c:forEach>
			</select>
												
							</tr>
					</c:forEach>
						
				  </tbody>
                  </table>
                  </div>	
                  </div>	
                  <br>
                  <br>
          
                  <button id="save" name="save" type="submit" class="btn btn-rounded btn-gradient-info mr-2">Save</button>
        
        
						</form>
					</div>
       
						</form>
					</div>
			

