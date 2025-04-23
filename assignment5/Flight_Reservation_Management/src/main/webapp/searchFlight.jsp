<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Search Flight</title>
</head>
<body>
<h1> ✈️✈️✈️✈️Search Flight✈️✈️✈️✈️</h1>
<form action="searchFlight" method=post >
<pre>
<h2>
From:<input type="text" name="from">
To:<input type="text" name="to">
Date:<input type="date" name="date">
<input type="submit" value="search">
<a href="cancelFlight.jsp">Cancel Flight</a>
</h2>
</pre>
</form>

</body>
</html>