<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.GregorianCalendar"%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hello</title>
</head>
<body>
<h2>Creaci�n de p�gina</h2>
<h1>Good <% if (new GregorianCalendar().get(Calendar.HOUR_OF_DAY) < 12) {%><br />Morning<br /><% } else { %><br />Afternoon<br /><% } %></h1>
</body>
</html>