package com.iig.gcp.login.dao;

import java.util.ArrayList;

import com.iig.gcp.login.dto.Groupdetails;
import com.iig.gcp.login.dto.Project;
import com.iig.gcp.login.dto.UserAccount;

public interface LoginDAO {


	ArrayList<UserAccount> getUserAccount() throws Exception;

	String getMenuCodes(String menu_id, String project) throws Exception;

	ArrayList<Project> getProjects(String username)throws Exception;

	ArrayList<Groupdetails> getGroupDetails(int user_sequence) throws Exception;

	//ArrayList<Groupdetails> getGroupdeatils(String group_id)throws Exception;
	
}
