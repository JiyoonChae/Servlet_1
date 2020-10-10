package com.jy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jy.util.DBConnector;

public class BoardDAO {
	private DBConnector dbConnector;
	
	public BoardDAO() {
		dbConnector = new DBConnector();
	}
	
	//db의 data를 가지고오기만 하면됨 = select
	public ArrayList<BoardDTO> boardList() throws Exception {
		Connection con = dbConnector.getConnect();
		
		String sql = "select * from board ORDER BY num asc";
		
		PreparedStatement st = con.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ArrayList<BoardDTO> ar = new ArrayList<>();
		while(rs.next()) {
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setNum(rs.getLong("num"));
			boardDTO.setTitle(rs.getString("title"));
			boardDTO.setWriter(rs.getString("writer"));
			boardDTO.setContents(rs.getString("contents"));
			boardDTO.setRegDate(rs.getDate("regDate"));
			boardDTO.setHit(rs.getLong("hit"));
			ar.add(boardDTO);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return ar;
	}
}
