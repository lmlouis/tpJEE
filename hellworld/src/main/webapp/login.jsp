<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Auhthentification</title>
<link rel='stylesheet' type='text/css' href='style.css'/>
</head>
<body>
	<h1>Authentification</h1>
	<h2><%= new Date() %></h2>
	<%
	String login = request.getParameter("textLogin");
	String password = request.getParameter("textPassword");
	if(login==null) login="";
	if(password==null) password="";
	
	if(request.getMethod().equals("POST") && login.equals("admin") && password.equals("admin")){
	%>
	<h2> Bienvenu <%=login %></h2>
	<%} else{ %>
	<form method='post' action='login'>
		<label for='idLogin'>Login :</label>
		 <input id='idLogin' name='textLogin' type='text' value='<%=login %>' placeholder='vortre nom utilisateur' autofocus/><br/>
		<label for='idPassword'>Password :</label>
		 <input id='idPassword' name='textPassword' type='password' value='<%=login %>' placeholder='votre mot de passe'/><br/>
		<input name='btnSubmit' type='submit' value='Connexion'/><br/>
	</form>
	<%} %>
</body>
</html>