package com.jy.util;

public class TestMain {

	public static void main(String[] args) {
		DBConnector db = new DBConnector();
		
		try {
			db.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
