<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style>
   tr:first-child{
       font-weight: bold;
       background-color: #C6C9C4;
   }
   
   table {
    border-collapse: collapse;
}

table, th, td {
    border: 1px solid black;
}
</style>

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
        File to upload: <input type="file" name="file" accept="text/plain"><br />
		Name: <input type="text" name="name"><br />
		<input type="submit" value="Upload"> Press here to upload the file!
	    </form>	
		
		<h3>
			${message} ${name} 
		</h3>
		
		<a href="parse"> Parse File</a> <a href="list"> Show Lines Statistics</a>
		<form method="get" action="/parse">
		<input type="button"  onclick="location.href='parse'" value="Parse File" >
		</form>
		<h3>${messageEx}</h3>
		
		
		
		<h2>List of Lines</h2>  
    <table>
        <tr>
            <td width="700px">Line<td>Longest word</td><td>Shortest word</td><td>Line Length</td><td>Average Word Length</td><td  width="40px"></td>
        </tr>
        <c:forEach items="${listLines}" var="listLine">
            <tr>
            <td>${listLine.line}</td>
            <td>${listLine.longest_word}</td>
            <td>${listLine.shortest_word}</td>
            <td>${listLine.line_length}</td>
            <td>${listLine.average_w_length}</td>
            <td><a href="<c:url value='/delete-${listLine.line_id}-line' />">delete</a></td>
            </tr>
        </c:forEach>
    </table>
	

</body>
</html>