<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<script src="<c:out value="${pageContext.request.contextPath}"/>/js/date.js" type="text/javascript"></script>
<script src="http://code.jquery.com/jquery-2.1.1.min.js" type="text/javascript"></script>

<script type="text/javascript">
//init date value
$( document ).ready(function() {

	});
</script>

<link href="<c:out value="${pageContext.request.contextPath}"/>/css/tableStyle1.css" rel="stylesheet"/>
<link href="<c:out value="${pageContext.request.contextPath}"/>/css/tableStyle2.css" rel="stylesheet"/>
</head>

<body>
	<div style="text-align:center;width:1280px;margin:0 auto;">
		<%@include file="../header.jsp" %>
		
		<form action="<c:out value="${pageContext.request.contextPath}"/>/function/view" method="get">
			<table  class="flat-table2" style="margin-left: 50px">
				<tr><td><spring:message code="bomDialog.id" /></td><td><input type="text" name="id" id="id" value="<c:out value="${id}"/>"/></td></tr>
				<tr><td><spring:message code="bomDialog.ip" /></td><td><input type="text" name="ip" id="ip" value="<c:out value="${ip}"/>"/></td></tr>

				<tr><td colspan="2"><input type="submit"value="<spring:message code="jsp.com.query"/>" /></td></tr>
			</table>
		</form>
	
			<table class="flat-table">
			<tr>
				<td colspan="5">header</td>
				<th><spring:message code="bomDialog.id"/></th>
				<th><spring:message code="bomDialog.parent"/></th>
				<th><spring:message code="bomDialog.child"/></th>
				<th><spring:message code="bomDialog.childProd"/></th>
				<th><spring:message code="bomDialog.parentProd"/></th>

			</tr>
			<tr>
			</tr>
			<c:forEach var="translog" items="${translogs}">
				<tr>
					<td><c:out value="${translog['id']}" /></td>
					<td><c:out value="${translog['parent']}" /></td>
					<td><c:out value="${translog['child']}" /></td>
					<td><c:out value="${translog['childProd']}" /></td>
					<td><c:out value="${translog['parentProd']}" /></td>
				
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
