<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./common/include/header.jsp" %>
		<c:if test="${null == sessionScope.MEMBER }">
			<ul>
				<li><a href="<c:url value="/member/login"/>">login</a></li>
			</ul>
		</c:if>
	</body>
</html>