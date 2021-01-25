<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/include/header.jsp" %>
		<h1>Login</h1>
		<form action='<c:url value="login"></c:url>' method="post">
			<input type="text" name="email" placeholder="email">
			<input type="password" name="password" placeholder="password">
			<input type="submit" value="LOGIN">
		</form>
	</body>
</html>