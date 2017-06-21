package org.servlet;
import java.sql.*;
import java.util.*;


public class DataAccess {
	private Connection con;
	private PreparedStatement pstmtgetQuestions,pstmtgetRandomQuestion,pstmtinsertscore;
	public DataAccess() throws SQLException{
		
		String jdbcurl="jdbc:mysql://localhost:3306/db1";
		String dbuser="root";
		String dbpass="root";
		com.mysql.jdbc.Driver d=new com.mysql.jdbc.Driver();
		DriverManager.registerDriver(d);
		con=DriverManager.getConnection(jdbcurl, dbuser, dbpass);
		pstmtgetQuestions=con.prepareStatement("select qid,qtext,opt1,opt2,opt3,opt4,copt,sub_name from questions");
		pstmtgetRandomQuestion=con.prepareStatement("select qid,qtext,opt1,opt2,opt3,opt4,copt from questions where sub_name=? order by rand() asc limit 5");
		pstmtinsertscore=con.prepareStatement("INSERT INTO score values (?,?,?,?,?)");
	
	}
	public UserPOJO entry(String fname,String lname,String mno,String emailid,String uname,String pass) throws SQLException{
		
		PreparedStatement pstmtsignup=con.prepareStatement(
				"insert into user_details(f_name, l_name, username, email_id ,m_no, password) values(?,?,?,?,?,?)");
		pstmtsignup.setString(1, fname);
		pstmtsignup.setString(2, lname);
		pstmtsignup.setString(3, uname);
		pstmtsignup.setString(4, emailid);
		pstmtsignup.setString(5, mno);
		pstmtsignup.setString(6, pass);
		pstmtsignup.executeUpdate();
		
		return null;
	}
	public ArrayList<QuestionsPojo> getRandomQuestions(String sname)throws SQLException{
		pstmtgetRandomQuestion.setString(1, sname);
		ResultSet rs=pstmtgetRandomQuestion.executeQuery();
		ArrayList<QuestionsPojo> list=null;
		while(rs.next())
		{
			if(list==null)
				list=new ArrayList<>();
			QuestionsPojo p=new QuestionsPojo();
			
			p.setQid(rs.getInt(1));
			p.setQtext(rs.getString(2));
			p.setOpt1(rs.getString(3));
			p.setOpt2(rs.getString(4));
			p.setOpt3(rs.getString(5));
			p.setOpt4(rs.getString(6));
			p.setCopt(rs.getInt(7));
		    p.setSub_name(sname);
			
			list.add(p);
			}
		return list;
	}
	public ArrayList<QuestionsPojo> getAllQuestions()throws SQLException{
		ResultSet rs=pstmtgetQuestions.executeQuery();
		ArrayList<QuestionsPojo> list=null;
		while(rs.next())
		{
			if(list==null)
				list=new ArrayList<>();
			QuestionsPojo p=new QuestionsPojo();
			
			p.setQid(rs.getInt(1));
			p.setQtext(rs.getString(2));
			p.setOpt1(rs.getString(3));
			p.setOpt2(rs.getString(4));
			p.setOpt3(rs.getString(5));
			p.setOpt4(rs.getString(6));
			p.setCopt(rs.getInt(7));
		    p.setSub_name(rs.getString(8));
			
			list.add(p);
			}
		return list;
	}

	public List<QuestionsPojo> getAnswerList(String subName)throws SQLException
	{
		String getScoreQuery = "select qid,copt from questions where sub_name=?";
		ResultSet rs = executeSelect(getScoreQuery, subName);
		List<QuestionsPojo> answerList=null;
		while(rs.next()){
			if(answerList==null){
				answerList=new ArrayList<>();
			}
			QuestionsPojo q=new QuestionsPojo(rs.getInt("qid"), rs.getInt("copt"));
			answerList.add(q);
		}
		return answerList;
	}
	private ResultSet executeSelect(String query, Object...params) throws SQLException {
		PreparedStatement pstmtgetAns=con.prepareStatement(query);
		int parameterIndex = 1;
		for(Object param : params){
			if(param instanceof String){
				pstmtgetAns.setString(parameterIndex, String.valueOf(param));
			}
			parameterIndex++;
		}
		ResultSet rs=pstmtgetAns.executeQuery();
		
		return rs;
	}
	
	
	
	
	}
	
	


