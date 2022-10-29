package com.verdical.api.verdical_api.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.verdical.api.verdical_api.model.VlUser;

@RestController
public class LMSController {
    
    private final static String USERNAME = "watson2lms";
    private final static String PASSWORD = "Verd2016!";
    private final static String URL = "jdbc:mysql://148.72.81.25:3306/i8971119_wp1?useSSL=false";
    private static final Logger LOGGER = LogManager.getLogger(LMSController.class);
    private static final String QUERY_USERS = "select wu.id, wu.user_registered, wu.user_email, wu.user_status from wp_users wu";
    private String QUERY_META = "select wm.meta_key, wm.meta_value from wp_usermeta wm where user_id=? and meta_key in('first_name','last_name')";

    @RequestMapping(value = "/getCustomers", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getCustomers() {
    	Connection conn = null;
    	ArrayList<VlUser> users = new ArrayList();
    	String jsonUsers = "";
        try {
            conn = getConnection();
            Statement st = conn.createStatement();
            ResultSet rs1 = st.executeQuery(QUERY_USERS);          
            while (rs1.next()){  
            	VlUser user = new VlUser();
            	user.setId(rs1.getInt("id"));
            	user.setEmail(rs1.getString("user_email"));
            	user.setIs_active(rs1.getBoolean("user_status"));
            	PreparedStatement pt = conn.prepareStatement(QUERY_META);
            	pt.setInt(1, rs1.getInt("id"));
            	ResultSet ptr = pt.executeQuery();
            	while(ptr.next()) {
            		if(StringUtils.equalsIgnoreCase(ptr.getString("meta_key"),"first_name")){
            			user.setFirstName(ptr.getString("meta_value"));
            		}else {
            			user.setLastName(ptr.getString("meta_value"));
            		}
            		
            	}
            	user.setName(user.getFirstName()+" "+user.getLastName());
            	users.add(user);
            }
            st.close();
            jsonUsers = new Gson().toJson(users);
        } catch (Exception e) {
            System.err.println("Cannot connect to database server");
            LOGGER.error("Exception", e);
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("Database Connection Terminated");
                } catch (Exception e) {
                	LOGGER.error("Exception", e);
                }
            }
        }
        
        return jsonUsers;
    }
    
    private Connection getConnection() {
    	Connection conn = null;
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {
			LOGGER.error("InstantiationException", e);
		} catch (IllegalAccessException e) {
			LOGGER.error("IllegalAccessException", e);
		} catch (ClassNotFoundException e) {
			LOGGER.error("ClassNotFoundException", e);
		}
    	try {
    		conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			LOGGER.error("SQLException", e);
		}
    	return conn;
    }
}
