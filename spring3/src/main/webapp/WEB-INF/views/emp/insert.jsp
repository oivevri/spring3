<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>insert.jsp</title>
<style>
.sss {font-weight: bold;}
.error {color: red;}
</style>
</head>
<body>
	<h1>사원등록/수정</h1>
	<form:form action="empInsert" method="post" modelAttribute="emp"><!--이상태에서 default는 Get방식임  -->
	<!-- 아이디가 있으면 수정, 없으면 등록 -->
	<c:if test="${not empty emp.employeeId}">
	 <form:input path="employeeId" readonly="true"/><br>
	</c:if>
	
	<spring:message code="emp.firstName"/>
	<form:input path="firstName" placeholder="firstName"/><br>
	
	<spring:message code="emp.lastName"/> 
	<form:input path="lastName" placeholder="lastName"/>
	<form:errors path="lastName" cssClass="error" htmlEscape="false"/><br>
	
 	<spring:message code="emp.email"/> 
	<form:input path="email" placeholder="email"/><br>
	<form:errors path="email" cssClass="error" htmlEscape="false"/><br>
	
	<!-- select box 예제 -->
	<form:select path="jobId">
	<!-- items="${jobs}" 
			itemLabel="jobTitle" itemValue="jobId" -->
				<form:option value="">job 선택</form:option>
				<form:options items="${jobs}" 
				itemLabel="jobTitle" itemValue="jobId"/>
	</form:select>
	<form:errors path="jobId" cssClass="error" htmlEscape="false"/>
	<br> 
	 
	 

	<!-- check box 예제 --> 
<%-- 	<p>
	<label>job선택</label>
	<form:checkboxes items="${jobs}" itemLabel="jobTitle" itemValue="jobId" path="jobId" cssClass="sss"/>
	</p> 
	  --%>
	 
	 <!-- radio button 예제 -->
	<%-- <form:radiobuttons path="jobId" items="${jobs}"/> --%>
	
	
	<form:select path="departmentId" items="${departments}" 
			itemLabel="departmentName" itemValue="departmentId"/><br> 
			
	<form:input path="salary" placeholder="salary"/><br>
	<form:input path="departmentId" placeholder="departmentId"/><br>
	<form:input path="hireDate" placeholder="hireDate"/><br>
	
	<button>등록</button>
	</form:form>
</body>
</html>