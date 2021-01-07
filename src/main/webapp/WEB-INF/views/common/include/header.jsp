<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<style>
	      li {
	        display: inline;
	        border: 1px solid #bcbcbc;
	        padding: 10px;
	      }
	    </style>
	</head>
	<body>
		<div>
			<img style="width:100%" src="<c:url value="/resources/images/head.png"/>">
		</div>
		<c:if test="${null != sessionScope.MEMBER }">
			<div>
				welcome! ${sessionScope.MEMBER.email}</h3>
			</div>
			<ul>
				<li><a href="<c:url value="/member/logout"/>">logout</a></li>
				<li><a href="<c:url value="/board/write"/>">board write</a></li>
				<li><a href="<c:url value="/board/readList"/>">board readList</a></li>
			</ul>
		</c:if>