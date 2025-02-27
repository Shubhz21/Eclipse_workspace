<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP page</title>
</head>
<body>

<pre>
<% 

int a=20,b=40,c;  
out.print("answer is: "+(a+b));

out.println("<br/>");

out.println("hii");

out.println("<br/>");
 
int row,col;

out.println("<br/>");

for(row=1; row<6; row++){
	
	for(col=1; col<=row; col++){
		
		out.print("*");
		
	}
	
	out.println();
}

%>


<%!

int count=0;


  int increment(){
	
	return count++;
}
  

%>


<%

increment();%>


</pre>



</body>
</html>