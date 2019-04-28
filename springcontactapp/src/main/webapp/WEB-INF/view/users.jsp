<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page isELIgnored="false" %>  
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List - Contact Application</title>
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
			<h3> User List </h3>
			<table border="1">
				<tr>
					<th>SR</th>
					<th>USER</th>
					<th>NAME</th>
					<th>PHONE</th>
					<th>EMAIL</th>
					<th>ADDRESS</th>
					<th>USERNAME</th>
					<th>STATUS</th>			
				</tr>
				<c:forEach var="u" items="${userList}" varStatus="st">
				<tr>
					<td>${st.count}</td>		
					<td>${u.userId}</td>
					<td>${u.name}</td>
					<td>${u.phone}</td>
					<td>${u.email}</td>
					<td>${u.address}</td>
					<td>${u.loginName}</td>
					<td>${u.loginStatus}</td>		
				</tr>
				</c:forEach>
			</table>
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