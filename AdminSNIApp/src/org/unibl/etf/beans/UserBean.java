package org.unibl.etf.beans;

import java.io.Serializable;
import java.util.ArrayList;

import org.unibl.etf.dto.User;

public class UserBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private User user;
	private ArrayList<User> usersrArrayList;
	
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ArrayList<User> getUsersrArrayList() {
		return usersrArrayList;
	}
	public void setUsersrArrayList(ArrayList<User> usersrArrayList) {
		this.usersrArrayList = usersrArrayList;
	}
	
	

}
