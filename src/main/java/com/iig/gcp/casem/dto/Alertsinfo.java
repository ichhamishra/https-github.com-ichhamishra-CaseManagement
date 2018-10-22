package com.iig.gcp.casem.dto;

public class Alertsinfo {
	public String AlertId;
	public String EmployeeId;
	public String EmployeeName;
	public String dateGE;
	public String Justification;
	public String AuthorisingManager; 
	public String Status;
	public String  Assigneegroup;

	
	public String getAssigneegroup() {
		return Assigneegroup;
	}
	public void setAssigneegroup(String assigneegroup) {
		Assigneegroup = assigneegroup;
	}
	public String getAlertId() {
		return AlertId;
	}
	public void setAlertId(String alertId) {
		AlertId = alertId;
	}
	public String getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(String employeeId) {
		EmployeeId = employeeId;
	}
	public String getEmployeeName() {
		return EmployeeName;
	}
	public void setEmployeeName(String employeeName) {
		EmployeeName = employeeName;
	
	}
	public String getDateGE() {
		return dateGE;
	}
	public void setDateGE(String dateGE) {
		this.dateGE = dateGE;
	}
	public String getJustification() {
		return Justification;
	}
	public void setJustification(String justification) {
		Justification = justification;
	}
	public String getAuthorisingManager() {
		return AuthorisingManager;
	}
	public void setAuthorisingManager(String authorisingManager) {
		AuthorisingManager = authorisingManager;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public void setDateG(String string) {
		// TODO Auto-generated method stub
		
	}
}
	