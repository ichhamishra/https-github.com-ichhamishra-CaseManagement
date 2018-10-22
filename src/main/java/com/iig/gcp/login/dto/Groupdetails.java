package com.iig.gcp.login.dto;

import java.io.Serializable;

public class Groupdetails implements Serializable {
 

	private static final long serialVersionUID = 1L;
	
	private int group_sequence; 
	private String group_id;
	private String group_name ;
	private String group_type;
	
	public int getGroup_sequence() {
		return group_sequence;
	}
	public void setGroup_sequence(int group_sequence) {
		this.group_sequence = group_sequence;
	}
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getGroup_name() {
		return group_name;
	}
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	public String getGroup_type() {
		return group_type;
	}
	public void setGroup_type(String group_type) {
		this.group_type = group_type;
	}
}