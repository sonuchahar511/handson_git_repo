package com.chahar.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class SimpleJdbcTestApp {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost/ducat?useSSL=false", "yash", "root1234");
			Statement statement=connection.createStatement();
			
			
//			statement.execute("create table department203(dp_id INT PRIMARY KEY,dp_name VARCHAR(20))");
//			statement.execute("create table student202(st_id INT PRIMARY KEY, st_name VARCHAR(20),dp_id INT, FOREIGN KEY(dp_id) REFERENCES department202(dp_id))");
			ResultSet rs=statement.executeQuery("select * from department102 INNER JOIN student102 ON department102.dp_id = student102.dp_id");
			ResultSetMetaData rsmd=rs.getMetaData();
			System.out.println(rsmd.getColumnCount());
			while(rs.next()) {
				for(int i=1;i<rsmd.getColumnCount();i++) {
						System.out.print(rsmd.getColumnLabel(i)+"|");
				}
				System.out.println();
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					System.out.print(rs.getObject(i)+"|");
				}
				System.out.println();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
