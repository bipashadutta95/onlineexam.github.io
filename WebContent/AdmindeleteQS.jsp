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
<body>
<% Object obj=session.getAttribute("LIST");
ArrayList<QuestionsPojo> list=(ArrayList<QuestionsPojo>)obj;%>
<h2>QUESTIONS</h2>
<table border=1><tr><th>Select a value</th><th>QS ID</th><th>Option 1</th><th>Option 2</th><th>Option 3</th><th>Option 4</th><th>Correct Opt</th><th>Subject Name</th></tr>
<%for(QuestionsPojo t:list){ %>
<tr><td><input type="radio" value="<%=t.getQid()%>" name="radio"></td><td><%=t.getQid()%></td><td><%=t.getQtext()%></td><td><%=t.getOpt1()%></td><td><%=t.getOpt2()%></td><td><%=t.getOpt3() %></td><td><%=t.getOpt4() %><td><%=t.getSub_name() %></td></tr> 


<%} %>
</table>
</body>
</html>