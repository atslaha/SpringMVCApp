<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
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
        
        <form method="POST" action="uploadFile" enctype="multipart/form-data">
        File to upload: <input type="file" name="file"><br />
		Name: <input type="text" name="name"><br />
		<input type="submit" value="Upload"> Press here to upload the file!
	    </form>	
		
		<h3>
			${message} ${name} 
		</h3>
		
	

</body>
</html>