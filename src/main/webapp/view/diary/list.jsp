<%@page import="com.office.diary.DiaryDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="../include/title.jsp" />

<link href="./res/css/member/signup_form.css" rel="stylesheet" type="text/css">

<jsp:include page="../include/diary/diary.jsp" />

</head>
<body>

	<jsp:include page="../include/header.jsp" />

	<jsp:include page="../include/nav.jsp" />
	
	<article>
		<div class="article_wrap">
			
				<h3>THIS PAGEMY DIARIES</h3>
			
			<%
				List<DiaryDto> myDiaries = (List<DiaryDto>)request.getAttribute("myDiaries");
				for (int i = 0; i < myDiaries.size(); i++) {
					
				}
			
			%>
			
			<table border="1">
				<thead>
					<tr>
						<th>diaryNo</th>
						<th>diaryWord</th>
						<th>diaryRegDate</th>
						<th>diaryModDate</th>
						<th>memNo</th>
						<th>memId</th>
						<th>memPw</th>
						<th>memMail</th>
						<th>memPhone</th>
						<th>memRegDate</th>
						<th>memModDate</th>
					</tr>
				</thead>
				<tbody>
				<% 
				List<DiaryDto> myDiaries = (List<DiaryDto>)request.getAttribute("myDiaries");
				for (int i = 0; i < myDiaries.size(); i++) {
				%>
				
					<tr>
						<td><%= myDiaries.get(i).getDiaryNo() %></td>
						<td><%= myDiaries.get(i).getDiaryWord() %></td>
						<td><%= myDiaries.get(i).getDiaryRegDate() %></td>
						<td><%= myDiaries.get(i).getDiaryModDate() %></td>
						<td><%= myDiaries.get(i).getmemNo() %></td>
						<td><%= myDiaries.get(i).getmemId() %></td>
						<td><%= myDiaries.get(i).getmemPw() %></td>
						<td><%= myDiaries.get(i).getmemMail() %></td>
						<td><%= myDiaries.get(i).getmemPhone() %></td>
						<td><%= myDiaries.get(i).getmemRegDate() %></td>
						<td><%= myDiaries.get(i).getmemModDate() %></td>
					</tr>
				<% 
				}
				%>
					
				</tbody>
			</table>
			
			
	
			
		</div>
	</article>
	
	<jsp:include page="../include/footer.jsp" />

</body>
</html>