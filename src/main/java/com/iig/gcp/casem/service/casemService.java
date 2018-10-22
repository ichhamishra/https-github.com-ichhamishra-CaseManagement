package com.iig.gcp.casem.service;

import java.util.ArrayList;
import java.util.Map;

import javax.validation.Valid;

import com.iig.gcp.casem.dto.Alertsinfo;
import com.iig.gcp.casem.dto.OpsDetail;




public interface casemService {
	ArrayList<Alertsinfo> getAlertinfo() throws Exception;
	public Map<String, String> getSysIds();
	public ArrayList<String> getMDSysList();
	public ArrayList<String> getCtryList(String src_sys_id);
	public ArrayList<String> getCtryList1(String src_sys_id);
	public ArrayList<Alertsinfo> getAlertTable(String sys_id, String ctry_id);
	ArrayList<String> getopsList();
	void updategroupname(String alert_id, String group_name);
	ArrayList<Alertsinfo> getOPTable(String group_name);
	void updatecomment(String alert_id, String Comment, String user_name);
	public ArrayList<String> getMDSysList1();
	public ArrayList<OpsDetail> getAlertTable1(String sys_id, String ctry_id);
	public ArrayList<OpsDetail> getOpsDetail(String sys_id, String ctry_id);
	public ArrayList<String> getuserList();
	void updateassigneename( String alert_id,String user_name);


	

}

