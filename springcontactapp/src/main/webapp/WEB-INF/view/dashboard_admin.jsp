<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ page isELIgnored="false" %>  
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard - Contact Application</title>
<s:url var="url_css" value="/resources/css/style.css"/>
</head>
<s:url var="url_bg" value="/resources/images/bg.jpg"/>
<link href="${url_css}" rel="stylesheet" type="text/css"/>
<body background = "${url_bg}" >  <%-- JSP Expression Language (EL) makes it possible to easily access application data stored in JavaBeans components. JSP EL allows you to create expressions both (a) arithmetic and (b) logical --%>
	<table border="1" width="80%" align="center" >
		<tr>
			<td height="80px">
			<%-- header --%>
			<jsp:include page="include/header.jsp" ></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="25px">
			<jsp:include page="include/menu.jsp" ></jsp:include>
			</td>
		</tr>
		<tr>
			<td height="350px" valign="top">
			<%-- content --%>
			<h1> Admin Dashboard </h1>
			</td>
		</tr>
		<tr>
			<td height="25px">
			<%-- footer --%>
			<jsp:include page="include/footer.jsp" ></jsp:include>
			</td>
		</tr>
		

	</table>
</body>
</html>