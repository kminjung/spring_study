<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>/views/cafe/update.jsp</title>
</head>
<body>

<p>글정보를 수정했습니다.</p>
<a href="detail.do?num=${param.num }">수정한 글 자세히 보기</a>
<br/>
<a href="list.do">글 목록보기</a>

<!-- 
	<c:choose>
	<c:when test="${isSuccess }">
		<script>
			alert("수정 하였습니다.");
			location.href="list.do";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("수정 실패!");
			location.href="list.do";
		</script>
	</c:otherwise>
</c:choose>
 -->
</body>
</html>