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
			
			<%
				List<DiaryDto> myDiaries = (List<DiaryDto>)request.getAttribute("myDiaries");
				for (int i = 0; i < myDiaries.size(); i++) {
					
				}
			
			%>
			
			<table>
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
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
				</tbody>
			</table>
			
			
		<h3>THIS PAGEMY DIARIES</h3>
			
		</div>
	</article>
	
	<jsp:include page="../include/footer.jsp" />

</body>
</html>