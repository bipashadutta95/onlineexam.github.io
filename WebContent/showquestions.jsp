<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="org.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<style>
.button {
    background-color: #4CAF50;
    border: none;
    color: white;
    padding: 10px 28px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
    text-align: center;
    
}
</style>
<body>
<% Object obj=session.getAttribute(String.valueOf(session.getAttribute("sname"))+"_questions");
ArrayList<QuestionsPojo> list=(ArrayList<QuestionsPojo>)obj;
//String sub=(String)session.getAttribute("SUB");


%>
<form action="ScoreServlet">
<%
int size=list.size();
HashSet<Integer> hs=new HashSet<>();
//QuestionsPojo p= new QuestionsPojo();
//ArrayList<Integer> ar = new ArrayList<Integer>(); 
		int seed=(int)(Math.random()*10);
		Random r=new Random(seed);
		for(int i=0;i<5;i++){
			//System.out.println(r.nextInt(20));
			hs.add(r.nextInt(size));
		}
		for(int x:hs){
	  QuestionsPojo t=list.get(x);
	          	
		}
        
        
		
		
	
%>

<h2>Question Paper</h2>
<h3>Subject : <%=session.getAttribute("sname")%></h3>
<%int questionIndex=0;
for(QuestionsPojo t:list){ %>
<%=++questionIndex %>.<%=t.getQtext()%><br/>
<%int optionIndex = 0; %>
<input type="radio" value=<%=++optionIndex%> name="<%=t.getQid()%>" />1.<%=t.getOpt1() %><br/>
<input type="radio" value=<%=++optionIndex%> name="<%=t.getQid()%>" />2.<%=t.getOpt2() %><br/>
<input type="radio" value=<%=++optionIndex%> name="<%=t.getQid()%>" />3.<%=t.getOpt3() %><br/>
<input type="radio" value=<%=++optionIndex%> name="<%=t.getQid()%>" />4.<%=t.getOpt4() %><br/>
<% 
%>

<%} %>
<button class="button" align="center">Submit</button>

</form>


</body>
</html>