<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*" %>
    <%@ page import="org.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body><form>
<% Object obj=session.getAttribute(String.valueOf(session.getAttribute("sname"))+"_questions");
Object obj1=session.getAttribute("GIVENANS");

ArrayList<QuestionsPojo> list=(ArrayList<QuestionsPojo>)obj;%>

<%int questionIndex=0;
for(QuestionsPojo t:list){ %>
<%=++questionIndex %>.<%=t.getQtext() %><br/>
<%int optionIndex = 0; %>
<%=++optionIndex%>.<%=t.getOpt1() %><br/>
<%=++optionIndex%>.<%=t.getOpt2() %><br/>
<%=++optionIndex%>.<%=t.getOpt3() %><br/>
<%=++optionIndex%>.<%=t.getOpt4() %><br/>
Your Answer<%=obj %>
Correct Option :<%=t.getCopt() %><br/>

<%} %>

</form>
</body>
</html>