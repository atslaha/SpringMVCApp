<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<center>
		<h2>Hello new page!)))</h2>
		<form action="page" method="POST">
		      Text: <input type="text" name="text" /><br />
		      <input type="submit" value="Submit" />
        </form>
        
        <h2>
             ${text}
        </h2>
		
		
		
	</center>

</body>
</html>