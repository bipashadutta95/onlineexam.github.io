package org.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			DataAccess da=new DataAccess();
			List<QuestionsPojo> answerList=da.getAnswerList(String.valueOf(request.getSession().getAttribute("sname")));
			Map<Integer, QuestionsPojo> answerMap = new HashMap<Integer, QuestionsPojo>();
			for(QuestionsPojo answer : answerList){
				answerMap.put(answer.getQid(), answer);
			}
			QuestionsPojo q=new QuestionsPojo();
			
			int score=0;
			for(Map.Entry<String, String[]> oneQuestion : request.getParameterMap().entrySet()){
				
				int qId = Integer.valueOf(oneQuestion.getKey());
				int givenAns=Integer.valueOf(oneQuestion.getValue()[0]);
				HttpSession s=request.getSession(true);
				s.setAttribute("GIVENANS", givenAns);

				System.out.println("Question ID = "+qId+" :: Given Answer = "+givenAns);
				
				if(answerMap.containsKey(qId)){
					int correctAnswer = answerMap.get(qId).getCopt();
					if(givenAns==correctAnswer){
						score++;
					}
				}
			   
			}
			
				
			
			HttpSession s=request.getSession(true);
			s.setAttribute("SCORE", score);
			response.sendRedirect("calculatescore.jsp");
			System.out.println("your score is :"+score);
			
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//doGet(request, response);

}
}
