package com.jy.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {
	
	public Connection getConnect() throws Exception {
		//db 연결 ojdbc6.jar 가져와야함~
		//1. DB 연결 정보
		String user ="hr";
		String password="tiger";
		String url="jdbc:oracle:thin:@211.238.142.233:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		//2. DB 드라이버 문자열을 객체로,,?! 메모리에 로딩?? 뭔말
		Class.forName(driver);
		System.out.println("driver 로딩 성공!");
		
		//3. DB 로그인, CONNECTION 객체 반환
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println(con);
		
		return con;
	}
}
