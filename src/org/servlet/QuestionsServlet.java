package org.servlet;
import java.util.*;
import java.lang.*;



import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class QuestionsServlet
 */
@WebServlet("/QuestionsServlet")
public class QuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuestionsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			DataAccess da= new DataAccess();
			String sname=request.getParameter("sname").trim();
			/*//=======================================
			Set<String> questions=request.getParameterMap().keySet();
			for(String strqno:questions){
				String attemptedans=request.getParameterMap().get(strqno)[0];
				int ans=Integer.parseInt(attemptedans);
			}
			//==========================================================
			 
			 */
			ArrayList<QuestionsPojo> list=da.getRandomQuestions(sname);
		
			int size= list.size();
			
			//System.out.println("LIST££££££££££££"+list);
			if(list!=null)
			{
				HttpSession s=request.getSession(true);
				s.setAttribute(sname+"_questions",list);
				s.setAttribute("sname",sname);
				response.sendRedirect("showquestions.jsp");
		
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
				
}}
		catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	response.sendError(388,"error:"+e.getMessage());
}
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.setContentType("text/html");
		//PrintWriter out=response.getWriter();
		try {
			DataAccess da= new DataAccess();
			String sname=request.getParameter("sname").trim();
			ArrayList<QuestionsPojo> list=da.getRandomQuestions(sname);
			for(QuestionsPojo po:list){
				System.out.println("Qid : "+po.getQid());
			}
			if(list!=null)
			{
				HttpSession s=request.getSession(true);
				s.setAttribute("QS",list);
				response.sendRedirect("showquestions.jsp");
				/*HttpSession sub=request.getSession(true);
				sub.setAttribute("SUB", sub);
				response.sendRedirect("showquestions.jsp");*/
				
			}

			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		doGet(request, response);
	}

}
