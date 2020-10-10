package com.jy.board;

import java.util.ArrayList;

public class BoardService {
	private BoardDAO boardDAO;
	
	public BoardService() {
		// TODO Auto-generated constructor stub
		boardDAO = new BoardDAO();
	}
	
	public ArrayList<BoardDTO> boardList() throws Exception {
		//db에서 데이터를 dao에서 ar에 저장해서 service로 온거니까 매개변수 x
		ArrayList<BoardDTO> ar = boardDAO.boardList();
		
		return ar;
		
	}
}
