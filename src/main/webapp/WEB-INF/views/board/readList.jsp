<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/include/header.jsp" %>
		<h1>Board List</h1>
		<c:forEach var="board" items="${boardList }">
		<ul>
			<li>${board.seq }</li>
			<li><a href='<c:url value="/board/readOne?id=${board.seq }"/>'>${board.title }</a></li>
			<li>${board.email }</li>
			<li>${board.reg_date }</li>
		</ul>
		</c:forEach>
		<div>
			<span>[Prev]</span>
			<c:forEach var="pNo" begin="1" end="${requestScope.page.pageCnt }" >
				<c:if test="${pNo != requestScope.page.pageNo }">
					<span>[<a href="<c:url value="/board/readList?pageNo=${pNo }"/>">${pNo }</a>]</span>
				</c:if>
				<c:if test="${pNo == requestScope.page.pageNo }">
					<span>[${pNo }]</span>
				</c:if>
			</c:forEach>
			<span>[Next]</span>
		</div>
	</body>
</html>