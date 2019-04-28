<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="f" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>  
 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Contact Form - Contact Application</title>
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
			<h3> Contact Form </h3>
			<c:if test = "${err!=null}">
			<p class="error"> ${err}</p>
			</c:if>
			<c:if test = "${param.act eq 'lo'}">
			<p class="success">Logout Successfully! Thank you for using contact application.</p>
			</c:if>
			<s:url var="url_csave" value="/user/save_contact" />
			<f:form action="${url_csave}" modelAttribute="command">
			<table border="1">
				<tr>
					<td>Name</td>
					<td><f:input path="name"  /> </td> <!-- These are Command properties (mentioned in path) -->	
				</tr>
				<tr>
					<td>Phone</td>
					<td><f:input path="phone"  /> </td>			
				</tr>
				<tr>
					<td>Email</td>
					<td><f:input path="email"  /> </td>			
				</tr>
				<tr>
					<td>Address</td>
					<td><f:textarea path="address"  /> </td>			
				</tr>
				<tr>
					<td>Remark</td>
					<td><f:textarea path="remark"  /> </td>			
				</tr>
				
					<td colspan="2" align="right">
					<button>SAVE</button>
					</td>		
				</tr>			
			</table>			
			</f:form>
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