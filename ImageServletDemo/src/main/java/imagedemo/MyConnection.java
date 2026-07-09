package imagedemo;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {

	public static Connection getConnection() {
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			 Connection con
             = DriverManager.getConnection(
            		 "jdbc:mysql://localhost:3306/ImageUpload_db","root","Root@123");
			 
			 return con;
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
