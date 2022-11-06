package com.example.jdbcWebExample.dbConf;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Named;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Db {
	//@Named("jdbc/basic")
	//private static DataSource datasource;
	
	private static final String CONTEXT = "java:/comp/env";
	private static final String DATASOURCE = "jdbc/basic";

	public static Connection getConnection() throws SQLException {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup(CONTEXT);
			DataSource ds  = (DataSource) envContext.lookup(DATASOURCE);
			return ds.getConnection();
		} catch (javax.naming.NamingException e) {
			System.out.println("+++++++++++++NAMING excpetion ");
			return null;
		}catch(SQLException se) {
		//Gestire errori per  JDBC
		se.printStackTrace();
		System.out.println("+++++++++++Errore creazione datasource ");
		return null;
        	}
	}
}
