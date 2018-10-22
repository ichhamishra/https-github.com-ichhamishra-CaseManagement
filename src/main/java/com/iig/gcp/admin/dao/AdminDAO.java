package com.iig.gcp.admin.dao;

import java.util.ArrayList;

import javax.validation.Valid;

import com.iig.gcp.admin.dto.Feature;

public interface AdminDAO {
	String getUser(String user) throws Exception;

	ArrayList<Feature> getFeatures(String userid, String project) throws Exception;

	ArrayList<Feature> getFeaturesAlready(String userid, String project)throws Exception;

	int getUserSequence(String userid)throws Exception;

	void onboardUser(int projectseq, int selectUser_Seq, String feature_seq)throws Exception;

	public String registerProject(@Valid String projectId, String projectName, String projectOwner, String projectDescription, String user) throws ClassNotFoundException, Exception;
	int getProjectSeq(@Valid String projectId) throws Exception;
	String registerAddAdminAccess(int projectSeq, int user_sequence) throws Exception;
}
