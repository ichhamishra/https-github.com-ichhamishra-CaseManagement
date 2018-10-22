<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <div class="row">
<div class="form-group col-md-12 ">

<form class="forms-sample" id="extractionExtractData" name="extractionExtractData" method="POST" action="/casem/viewsubmit">						

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
                       Assigned To
                       </th>
                        <th>
                          Assignee Group
                        </th>
                      </tr>
                    </thead>
                    <tbody>
                   
	                   <c:forEach items="${tableList}" var="alertsinfo">
	                   <input type="hidden" name="alert_id" id="alert_id" value="${alertsinfo.getAlertId()}">
						<tr class="table-default">
							<td><div style="height:100%;width:100%">${alertsinfo.getAlertId()}</td>
							<td>${alertsinfo.getEmployeeId()}</td>
							<td>${alertsinfo.getEmployeeName()}</td>
							<td>${alertsinfo.getDateGE()}</td>
							<td>${alertsinfo.getJustification()}</td>
							<td>${alertsinfo.getAuthorisingManager()}</td>
							<td>${alertsinfo.getStatus()}</td>
							<td>${alertsinfo.getAssigneegroup()}</td>
							<td style="width:150px">
											<select name="group_name" id="group_name" class="form-control form-control1">
		<option value="" selected disabled>Select group name..</option>
		<c:forEach items="${grouplist}" var="fileId">
			<option value="${fileId}">${fileId}</option>
			</c:forEach>
			</select>
							</td>	

						</tr>
					</c:forEach>
				  </tbody>
                  </table>
                  </div>	
                  <br>
                  <br>
          
                  <button id="save" name="save" type="submit" class="btn btn-rounded btn-gradient-info mr-2">Save</button>
        
        
						</form>
					</div>
			

