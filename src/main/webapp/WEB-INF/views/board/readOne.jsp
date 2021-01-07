<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/include/header.jsp" %>
		<h1>Board Detail</h1>
		<div>
			<span>id:${board.id }</span><br>
			<span>title:${board.title }</span><br>
			<span>content:${board.content }</span><br>
			<span>email:${board.email }</span><br>
			<span>file1Name:<a href="<c:url value="/board/download?file1Name=${board.file1Name }&file1SName=${board.file1SName }"/>">${board.file1Name }</a></span><br>
			<span>reg_date:${board.reg_date }</span><br>
			<span>update_date:${board.update_date }</span>
		</div>
		<div>
			<c:if test="${board.m_id == sessionScope.MEMBER.id }">
				<input type="button" id="updBtn" value="Update"/>
				<input type="button" id="delBtn" value="Delete"/>
			</c:if>
		</div>
		<script>
			document.getElementById('updBtn').addEventListener('click',function(){
				document.location.href = '<c:url value="/board/update?id=${board.id }"/>';
			});
			document.getElementById('delBtn').addEventListener('click',function(){
				if(confirm('Really Delete?')){
					document.location.href = '<c:url value="/board/delete?id=${board.id }"/>';
				}
			});
		</script>
	</body>
</html>