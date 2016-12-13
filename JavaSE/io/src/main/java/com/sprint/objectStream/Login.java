package com.sprint.objectStream;

import java.io.*;
import java.util.*;
public class Login implements Serializable {
	private Date date = new Date();
	private String username;
	private transient String password;

	public Login(String name, String pwd) {
		username = name;
		password = pwd;
	}

	public String toString() {
		return "login info:\n username: " + username + " \n date: " + date + "\n password: " + password; 
	}

}
