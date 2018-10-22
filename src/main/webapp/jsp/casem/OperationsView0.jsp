<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
         <div class="row">
<div class="form-group col-md-12 ">

<form class="forms-sample" id="extractionExtractData" name="extractionExtractData" method="POST" action="/extract/extractionExtractData1" enctype="application/json">						

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
                          Assignee Name
                        </th>
                      </tr>
                    </thead>
                    <tbody>
                   
	                   <c:forEach items="${tableList}" var="alertsinfo">
						<tr class="table-default">
							<td><div style="height:100%;width:100%">${alertsinfo.getAlertId()}</td>
							<td>${alertsinfo.getEmployeeId()}</td>
							<td>${alertsinfo.getEmployeeName()}</td>
							<td>${alertsinfo.getDateGE()}</td>
							<td>${alertsinfo.getJustification()}</td>
							<td>${alertsinfo.getAuthorisingManager()}</td>
							<td>${alertsinfo.getStatus()}</td>
							<td>${alertsinfo.getAssignee_name()}</td>
			</c:forEach>
			</select>
							</td>	
						</tr>
				
				  </tbody>
                  </table>
                  </div>	
                  <br>
                  <br>
				  <br>
						  <div class="row">
						  <h4 class="card-title">Comments</h4>
						  <input type="text" class="form-control" id="Comment" name="Comment" placeholder="Comment" width="25em";  height:"2em"; >
				  <br>
						
                          <a href="/Case/assigneecomment">
                          <br></br>
          
                  <button id="save" name="save" type="submit" class="btn btn-rounded btn-gradient-info mr-2">Save</button>
                 
						</form>
					</div>
				</div>
			</div>
		</div>  
		</div>  
		</div> 

