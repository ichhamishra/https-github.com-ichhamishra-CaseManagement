package com.iig.gcp.login.dao;


import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.iig.gcp.login.dto.Groupdetails;
import com.iig.gcp.login.dto.Project;
import com.iig.gcp.login.dto.UserAccount;
import com.iig.gcp.utils.ConnectionUtils;

@Component
public class LoginDAOImpl implements LoginDAO {

	@Override
	public ArrayList<UserAccount> getUserAccount() throws Exception {
		
		ArrayList<UserAccount> arrUsers= new ArrayList<UserAccount>();
		String sql = "select user_id,user_pass,user_sequence, coalesce(is_admin,'N') as is_admin from juniper_admin.casemgmt_user_details";

		Connection conn= ConnectionUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql); 
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
				UserAccount user = new UserAccount();
				user.setUser_id(rs.getString(1));
				user.setUser_pass(rs.getString(2));
				user.setUser_sequence(rs.getInt(3));
				user.setIs_admin(rs.getString(4));;
				arrUsers.add(user);	
		}
		ConnectionUtils.closeQuietly(conn);
		return arrUsers;
	}

	/*@Override
	public ArrayList<Groupdetails> getGroupdetails() throws Exception {
		
		ArrayList<Groupdetails> arrgroups= new ArrayList<Groupdetails>();
		String sql = "select p.group_id,p.group_name,p.group_sequence,p.group_type from casemgmt_user_group_link l inner join casemgmt_user_details u on l.user_sequence=u.user_sequence inner join casemgmt_group_details p on l.group_sequence=p.group_sequence where u.user_id=?";

		Connection conn= ConnectionUtils.getConnection();
		PreparedStatement pstm = conn.prepareStatement(sql); 
		ResultSet rs = pstm.executeQuery();
		while (rs.next()) {
				Groupdetails group = new Groupdetails();
				group.setGroup_id(rs.getString(1));
				group.setGroup_name(rs.getString(2));
				group.setGroup_sequence(rs.getInt(3));
				group.setGroup_type(rs.getString(4));;
				arrgroups.add(group);	
		}
		ConnectionUtils.closeQuietly(conn);
		return arrgroups;
	}*/
	
	@Override
	public String getMenuCodes(String group_id,String project) throws Exception {
		 	String menu_code="";
	        String menu_link=null;
	        ArrayList<String> menu_name=new ArrayList<String>();
	        ArrayList<Integer> menu_levell=new ArrayList<Integer>();       
	        int menu_level=0;
	        int i=0;
	        
	        String sql = "SELECT f.feature_link,f.feature_level,f.feature_name FROM casemgmt_proj_f_group_link l INNER JOIN casemgmt_group_details u ON l.group_sequence = u.group_sequence INNER JOIN casemgmt_project_details p ON l.project_sequence = p.project_sequence INNER JOIN casemgmt_feature_details f ON l.feature_sequence = f.feature_sequence WHERE u.group_id =? AND p.project_id = ? order by f.feature_order";
			Connection conn= ConnectionUtils.getConnection();

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, group_id);
			pstm.setString(2, project);
			ResultSet rs = pstm.executeQuery();
			while(rs.next())
			{
				menu_link = rs.getString(1);
				menu_level = rs.getInt(2);
				menu_name.add(rs.getString(3));
				menu_levell.add(menu_level);
				if(menu_level==1)
				{
					if(i==0)
					{
						menu_code=menu_link;
					}
					else
					{
						menu_code=menu_code+"</ul></li>"+menu_link;
					}
				}
				else
				{
					menu_code=menu_code+menu_link;
				}
				i++;
			}
			menu_code=menu_code+"</ul></li>";


		ConnectionUtils.closeQuietly(conn);

		return menu_code;
	}

	@Override
	public ArrayList<Project> getProjects(String group_id) throws Exception {
		
		  ArrayList<Project> arrProject=new ArrayList<Project>();
		  String sql = "select distinct p.project_id,p.project_sequence from casemgmt_proj_f_group_link l inner join casemgmt_group_details u on l.group_sequence=u.group_sequence inner join casemgmt_project_details p on l.project_sequence=p.project_sequence where u.group_id=?";
			Connection conn= ConnectionUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, group_id);
			ResultSet rs = pstm.executeQuery();
			Project prj =null;
			while (rs.next()) {
				prj=new Project();
				prj.setProject_id(rs.getString(1));
				prj.setProject_sequence(rs.getInt(2));
				arrProject.add(prj);	
		}
		ConnectionUtils.closeQuietly(conn);
		return arrProject;
		
	}

	@Override
	public ArrayList<Groupdetails> getGroupDetails(int user_sequence) throws Exception {
		
		ArrayList<Groupdetails> arrGroupDetails =new ArrayList<Groupdetails>();
		  String sql = "select a.group_id,a.group_name,a.group_sequence from casemgmt_group_details a inner join casemgmt_user_group_link b on a.group_sequence=b.group_sequence where b.user_sequence=?";

		  Connection conn= ConnectionUtils.getConnection();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setInt(1, user_sequence);
			ResultSet rs = pstm.executeQuery();
			Groupdetails grpDet =null;
			while (rs.next()) {
				grpDet=new Groupdetails();

				grpDet.setGroup_id(rs.getString(1));
				
				arrGroupDetails.add(grpDet);	
		}
		ConnectionUtils.closeQuietly(conn);
		
		
		return arrGroupDetails;
	}

}
