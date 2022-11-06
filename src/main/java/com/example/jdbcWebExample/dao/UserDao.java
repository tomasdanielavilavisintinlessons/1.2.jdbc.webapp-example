package com.example.jdbcWebExample.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.jdbcWebExample.dbConf.Db;

public class UserDao {
	

    private static UserDao INSTANCE;
    private String info = "Initial info class";
    
    private UserDao() {        
    }
    
    public static UserDao getInstance() {
        if(INSTANCE == null) {
            INSTANCE = new UserDao();
        }
        
        return INSTANCE;
    }
	
	public List<String> getAllUsers() {
		try(Connection con = Db.getConnection();) {
			String res;
			Statement st = con.createStatement();
    		
    		String query = "select * from users";
    		
    		ResultSet result = st.executeQuery(query);
    		
    		List<String> users = new ArrayList<>();
    		
    		while(result.next()) {
    			
    			int id = result.getInt("id");
    			String name = result.getString("name");
    			int age = result.getInt("age");
    			String gender = result.getBoolean("gender") ? "Female" : "Male";
    			
    			String user = String.format("%s, %s, %d years old", name, gender, age);
    			users.add(user);
    		}
    		
    		// Chiusura 
    		result.close();
    		st.close();
    		con.close();
    		
    		return users; 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} 
	}
}
