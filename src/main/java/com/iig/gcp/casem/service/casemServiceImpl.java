package com.iig.gcp.casem.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iig.gcp.casem.dao.casemDAO;
import com.iig.gcp.casem.dto.Alertsinfo;
import com.iig.gcp.casem.dto.OpsDetail;
import com.iig.gcp.utils.ConnectionUtils;



@Service
public class casemServiceImpl implements casemService{
	
	@Autowired
	private casemDAO CasemDAO;
	

	
	@Override
	public ArrayList<Alertsinfo> getAlertinfo() throws Exception {
		// TODO Auto-generated method stub
				return CasemDAO.getAlertinfo();
			}

	@Override
	public ArrayList<String> getopsList() {
		Connection conn = null;
		try{
			Connection conn1 = ConnectionUtils.getConnection();
			ArrayList<String> group_list=new ArrayList<>();
			String s_id="select GROUP_NAME from juniper_admin.casemgmt_group_details";
			Statement statement = conn1.createStatement();
			ResultSet rs =statement.executeQuery(s_id);
			while (rs.next()) {
				group_list.add(rs.getString(1));
			}
			//ConnectionUtils.closeQuietly(conn);
			conn1.close();
			return group_list;
		}catch(Exception e){
			//conn.close();
			return null;	
			
		}
	}

	@Override
	public Map<String, String> getSysIds() {
		Connection conn = null;
		try{
			Map<String,String> src_map= new HashMap<String, String>();
			String s_id="select systemname from juniper_admin.casemgmt_alert_details";
			Statement statement = conn.createStatement();
			ResultSet rs =statement.executeQuery(s_id);
			while (rs.next()) {
				src_map.put(rs.getString(1), rs.getString(2));
			}
			//ConnectionUtils.closeQuietly(conn);
			conn.close();
			return src_map;
		}catch(Exception e){
			//conn.close();
			return null;	
		}
	}



	@Override
	public ArrayList<String> getMDSysList() {
		try{
			Connection conn = ConnectionUtils.getConnection();
			ArrayList<String> src_list=new ArrayList<>();
			String s_id="select systemname from juniper_admin.casemgmt_alert_details";
			PreparedStatement pstm = conn.prepareStatement(s_id);
			ResultSet rs =pstm.executeQuery();
			while (rs.next()) {
				src_list.add(rs.getString(1));
							}
			ConnectionUtils.closeQuietly(conn);
			//conn.close();
			return src_list;
		}catch(Exception e){
			//conn.close();
			return null;	
		}
	}

	@Override
	public ArrayList<String> getMDSysList1() {
		try{
			Connection conn = ConnectionUtils.getConnection();
			ArrayList<String> src_list=new ArrayList<>();
			String s_id="select systemname from juniper_admin.casemgmt_alert_details";
			PreparedStatement pstm = conn.prepareStatement(s_id);
			ResultSet rs =pstm.executeQuery();
			while (rs.next()) {
				src_list.add(rs.getString(1));
							}
			ConnectionUtils.closeQuietly(conn);
			//conn.close();
			return src_list;
		}catch(Exception e){
			//conn.close();
			return null;	
		}
	}

	public ArrayList<String> getCtryList(String src_sys_id)
	{
		try{
			Connection conn = ConnectionUtils.getConnection();
			ArrayList<String> src_list=new ArrayList<>();
			System.out.println("in service :"+src_sys_id);
			String s_id="select country from juniper_admin.casemgmt_alert_details where systemname='"+src_sys_id+"'";
			System.out.println(s_id);
			PreparedStatement pstm = conn.prepareStatement(s_id);
			ResultSet rs =pstm.executeQuery();
			while (rs.next()) {
				src_list.add(rs.getString(1));
				System.out.println("in service liat :"+rs.getString(1));
							}
			ConnectionUtils.closeQuietly(conn);
			//conn.close();
			return src_list;
		}catch(Exception e){
			//conn.close();
			return null;	
		}
	}
	
	public ArrayList<String> getuserList()
	{
		try{
			Connection conn = ConnectionUtils.getConnection();
			ArrayList<String> src_list=new ArrayList<>();
			String s_id="select user_id from juniper_admin.casemgmt_user_details";
			System.out.println(s_id);
			PreparedStatement pstm = conn.prepareStatement(s_id);
			ResultSet rs =pstm.executeQuery();
			while (rs.next()) {
				src_list.add(rs.getString(1));
				System.out.println("in service liat :"+rs.getString(1));
							}
			ConnectionUtils.closeQuietly(conn);
			//conn.close();
			return src_list;
		}catch(Exception e){
			//conn.close();
			return null;	
		}
	}
	
	public ArrayList<String> getCtryList1(String src_sys_id)
	{
		try{
			Connection conn = ConnectionUtils.getConnection();
			ArrayList<String> src_list=new ArrayList<>();
			System.out.println("in service :"+src_sys_id);
			String s_id="select country from juniper_admin.casemgmt_alert_details where systemname='"+src_sys_id+"'";
			System.out.println(s_id);
			PreparedStatement pstm = conn.prepareStatement(s_id);
			ResultSet rs =pstm.executeQuery();
			while (rs.next()) {
				src_list.add(rs.getString(1));
				System.out.println("in service liat :"+rs.getString(1));
							}
			ConnectionUtils.closeQuietly(conn);
			//conn.close();
			return src_list;
		}catch(Exception e){
			//conn.close();
			return null;	
		}
	}
	public ArrayList<Alertsinfo> getAlertTable(String sys_id, String ctry_id)
	{
		try{
			Connection conn = ConnectionUtils.getConnection();
			ArrayList<Alertsinfo> bean_list=new ArrayList<>();
			String s_id="Select ALERT_ID,EMPLOYEE_ID,EMPLOYEE_NAME,DATEG,JUSTIFICATION,AUTHORISING_MANAGER,STATUS,ASSIGNEE_GROUP from juniper_admin.casemgmt_alert_details where SYSTEMNAME='"+sys_id+"'  and COUNTRY='"+ctry_id+"'";
			System.out.println(s_id);
			PreparedStatement pstm = conn.prepareStatement(s_id);
			ResultSet rs =pstm.executeQuery();
			while (rs.next()) {
				Alertsinfo alertsinfo=new Alertsinfo();
				bean_list.add(alertsinfo);
				alertsinfo.setAlertId(rs.getString(1));
				alertsinfo.setEmployeeId(rs.getString(2));
				alertsinfo.setEmployeeName(rs.getString(3));
				alertsinfo.setDateGE(rs.getString(4));// .setdateGE(rs.getString(5));
				alertsinfo.setJustification(rs.getString(5));
				alertsinfo.setAuthorisingManager(rs.getString(6));
				alertsinfo.setStatus(rs.getString(7));
				alertsinfo.setAssigneegroup(rs.getString(8));
				System.out.println(rs.getString(1));
				}
			ConnectionUtils.closeQuietly(conn);
			//conn.close();
			return bean_list;
		}catch(Exception e){
			//conn.close();
			return null;	
		}
	}

	
	public ArrayList<OpsDetail> getAlertTable1(String sys_id, String ctry_id)
	{
		ArrayList<OpsDetail> bean_list=new ArrayList<>();
		try{
			Connection conn = ConnectionUtils.getConnection();
			String s_id="Select ALERT_ID,EMPLOYEE_ID,EMPLOYEE_NAME,DATEG,JUSTIFICATION,AUTHORISING_MANAGER,STATUS,ASSIGNEE_NAME from juniper_admin.casemgmt_alert_details where SYSTEMNAME='"+sys_id+"'  and COUNTRY='"+ctry_id+"'";
			System.out.println(s_id);
			PreparedStatement pstm = conn.prepareStatement(s_id);
			ResultSet rs =pstm.executeQuery();
			while (rs.next()) {
				OpsDetail opsdetail=new  OpsDetail();
				bean_list.add(opsdetail);
				opsdetail.setAlertId(rs.getString(1));
				opsdetail.setEmployeeId(rs.getString(2));
				opsdetail.setEmployeeName(rs.getString(3));
				opsdetail.setDateGE(rs.getString(4));// .setdateGE(rs.getString(5));
				opsdetail.setJustification(rs.getString(5));
				opsdetail.setAuthorisingManager(rs.getString(6));
				opsdetail.setStatus(rs.getString(7));
				opsdetail.setAssigneegroup(rs.getString(8));
				}
			ConnectionUtils.closeQuietly(conn);
			//conn.close();2
			//return bean_list;
		}catch(Exception e){
			//conn.close();
			return null;	
		}
		return bean_list;
	}
@Override
public ArrayList<Alertsinfo> getOPTable( String group_name) {
	// TODO Auto-generated method stub
	try{
		Connection conn = ConnectionUtils.getConnection();
		ArrayList<Alertsinfo> bean_list=new ArrayList<>();
		String s_id="Select  Alert_Id,Employee_Id,Employee_Name,Expense_Amount,dateG,PublicOfficial,Justification,CostCentreCode,Authorising_Manager,Status from juniper_admin.casemgmt_alert_details where Assignee_name='"+group_name+"'";
		PreparedStatement pstm = conn.prepareStatement(s_id);
		ResultSet rs =pstm.executeQuery();
		while (rs.next()) {
			Alertsinfo alertsinfo=new Alertsinfo();
			bean_list.add(alertsinfo);
			alertsinfo.setAlertId(rs.getString(1));
			alertsinfo.setEmployeeId(rs.getString(2));
			alertsinfo.setEmployeeName(rs.getString(3));		
			alertsinfo.setDateG(rs.getString(5));// .setdateGE(rs.getString(5));	
			alertsinfo.setJustification(rs.getString(7));
			alertsinfo.setAuthorisingManager(rs.getString(8));
			alertsinfo.setStatus(rs.getString(8));
			}
		ConnectionUtils.closeQuietly(conn);
		//conn.close();
		return bean_list;
	}catch(Exception e){
		//conn.close();
		return null;	
	}
}
	


@Override
public void updategroupname(String alert_id, String group_name) {
	// TODO Auto-generated method stub
	try{
		Connection conn = ConnectionUtils.getConnection();
		String s_id="update juniper_admin.casemgmt_alert_details set Assignee_group='"+group_name+"' where Alert_id='"+alert_id+"'";
		System.out.println(s_id);
		PreparedStatement pstm = conn.prepareStatement(s_id);
		pstm.executeUpdate();
		ConnectionUtils.closeQuietly(conn);
		//conn.close();
	}catch(Exception e){
		//conn.close();	
	}
}
@Override
public void updateassigneename(String alert_id, String user_name) {
	// TODO Auto-generated method stub
	try{
		Connection conn = ConnectionUtils.getConnection();
		String s_id="update juniper_admin.casemgmt_alert_details set Assignee_name='"+user_name+"' where Alert_id='"+alert_id+"'";
		System.out.println(s_id);
		PreparedStatement pstm = conn.prepareStatement(s_id);
		pstm.executeUpdate();
		ConnectionUtils.closeQuietly(conn);
		//conn.close();
	}catch(Exception e){
		//conn.close();	
	}
}
@Override
public void updatecomment(String alert_id, String Comment, String user_name) {
	// TODO Auto-generated method stub
	try{
		Connection conn = ConnectionUtils.getConnection();
		String s_id="INSERT INTO juniper_admin.casemgmt_comment_details values('"+alert_id+"','"+Comment+"','"+user_name+"')";
		System.out.println(s_id);
		PreparedStatement pstm = conn.prepareStatement(s_id);
		pstm.executeQuery();
		ConnectionUtils.closeQuietly(conn);
		//conn.close();
	}catch(Exception e){
		//conn.close();	
	
}
}
@Override
public ArrayList<OpsDetail> getOpsDetail(@Valid String sys_id, String ctry_id) {
	// TODO Auto-generated method stub
	return null;
}}



