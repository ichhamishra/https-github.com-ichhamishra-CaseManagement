package com.iig.gcp.casem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.iig.gcp.casem.dao.casemDAO;
import com.iig.gcp.casem.dto.Alertsinfo;
import com.iig.gcp.login.dto.UserAccount;
import com.iig.gcp.utils.ConnectionUtils;

@Component
public class casemDAOImpl implements casemDAO {

	@Override
	public ArrayList<Alertsinfo> getAlertinfo() throws Exception {

		ArrayList<Alertsinfo> arrAlerts = new ArrayList<Alertsinfo>();
		String sql = "Select AlertId,EmployeeId,EmployeeName,ExpenseAmount,dateGE,PublicOfficial,Justification,CostCentreCode,AuthorisingManager,Status from juniper_admin.casemgmt_alert_details where systemname='HUB' and country='US'";

		Connection conn = ConnectionUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql);
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
			Alertsinfo alert = new Alertsinfo();
			alert.setAlertId(rs.getString(1));
			alert.setEmployeeId(rs.getString(2));
			alert.setEmployeeName(rs.getString(3));
		
			alert.setDateGE(rs.getString(5));// .setdateGE(rs.getString(5));
			
			alert.setJustification(rs.getString(7));
			
			alert.setAuthorisingManager(rs.getString(8));
			alert.setStatus(rs.getString(8));
			arrAlerts.add(alert);
		}
		ConnectionUtils.closeQuietly(conn);
		return arrAlerts;
	}
	
	
	
	public static void main(String args[]) throws Exception {
		casemDAO c = new casemDAOImpl();
		c.getAlertinfo();
		System.out.println("END");
	}
}
