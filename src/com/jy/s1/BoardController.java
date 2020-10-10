package com.jy.s1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jy.board.BoardDTO;
import com.jy.board.BoardService;

/**
 * Servlet implementation class BoardController
 */
@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private BoardService boardService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardController() {
        super();
        boardService = new BoardService();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Encoding
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String path = request.getRequestURI();
		path = path.substring(path.lastIndexOf("/"));
		System.out.println(path);
		
		if(path.equals("/boardList.board")) {
			
			ArrayList<BoardDTO> ar = null;
			try {
				ar = boardService.boardList();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("board", ar);
			
			RequestDispatcher view = request.getRequestDispatcher("./boardList.jsp");
			view.forward(request, response);
		}else {
			System.out.println("wrong");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
