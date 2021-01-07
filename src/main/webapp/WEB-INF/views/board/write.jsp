<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/include/header.jsp" %>
		<h1>Board Write</h1>
		<form action="<c:url value="/board/write"/>" method="post" enctype="multipart/form-data">
			<input type="text" name="title" placeholder="title"><br>
			<textarea name="content" placeholder="content"></textarea><br>
			<input type="file" name="file1"><br>
			<input type="submit" value="Write">
		</form>
	</body>
</html>