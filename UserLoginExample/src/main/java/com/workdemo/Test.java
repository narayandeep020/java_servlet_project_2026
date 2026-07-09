package com.workdemo;

public class Test {

	public static void main(String[] args) {
		
		try {
			System.out.println(DbConnection.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		LoginServlet ls = new LoginServlet();
		String pass = ls.getPasswordFormDb("Deep Narayan");
		
		System.out.println(pass);

	}

}
