<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>[phonebook2]</h1>
	<h2>전화번호 리스트</h2>
	
	<p>입력한 정보 내역입니다.</p>


	<c:forEach items="${pList}" var="vo">
		<table border="1">
			<tr>
				<td>이름(name)</td>
				<td>${vo.name}</td>
			</tr>
			<tr>
				<td>핸드폰(hp)</td>
				<td>${vo.hp}</td>
			</tr>
			<tr>
				<td>회사(company)</td>
				<td>${vo.company}</td>
			</tr>
			<tr>
				<td><button onclick="location.href='/phonebook3/phone/updateForm?personId=${vo.personId}'">수정</button></td>
				<td><button onclick="location.href='/phonebook3/phone/delete?personId=${vo.personId}'">삭제</button></td>
			</tr>
		</table>
		<br>
	</c:forEach>

	
	<a href = "/phonebook3/phone/writeForm"> 전화번호 등록폼</a>
</body>
</html>