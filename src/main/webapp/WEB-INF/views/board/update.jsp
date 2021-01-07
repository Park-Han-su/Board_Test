<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/include/header.jsp" %>
		<h1>Board Update</h1>
		<form action="<c:url value="/board/update"/>" method="post" enctype="multipart/form-data">
			<input type="hidden" name="id" value="${board.id }">
			<input type="text" name="title" placeholder="title" value="${board.title }"><br>
			<textarea name="content" placeholder="content">${board.content }</textarea><br>
			<span>file1Name:${board.file1Name }</span><br>
			<img style="width:50%" src="<c:url value="/resources/upload/${board.file1SName }"/>"><br>
			<input type="file" name="file1"><br>
			<input type="submit" value="Update">
		</form>
	</body>
</html>