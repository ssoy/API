<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="include.jsp"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일일 박스 오피스</title>
</head>
<body>
	<h2>일일 박스 오피스</h2>
	<form name="frmList" action="${path}/dailyTop" method="post">
		<input type="date" name="targetDt" required="required"
			value="${targetDt}"> <select name="multiMovieYn">

			<option value="" <c:out value="${multiMovieYn==''?'selected':'' }"/>>전체</option>
			<option value="Y"
				<c:out value="${multiMovieYn=='Y'?'selected':'' }"/>>다양성 영화</option>
			<option value="N"
				<c:out value="${multiMovieYn=='N'?'selected':'' }"/>>상업영화</option>
		</select> <select name="repNationCd">
			<option value="" <c:out value="${repNationCd==''?'selected':'' }"/>>전체</option>
			<option value="K" <c:out value="${repNationCd=='K'?'selected':'' }"/>>한국영화</option>
			<option value="F" <c:out value="${repNationCd=='F'?'selected':'' }"/>>외국영화</option>
		</select> <input type="submit" value="조회">

	</form>
	<!-- 영화리스트 -->
	<%-- ${rList} --%>
	<table border="1">
		<tr>
			<th>순위</th>
			<th>관객수</th>
			<th>누적매출액</th>
			<th>상영 스크린수</th>
			<th>순위의 증감분</th>
			<th>상영작의 매출총액 대비 <br>해당 영화의 매출비율</th>
			<th>영화명</th>
			<th>해당일의 매출액</th>
			<th>대표코드</th>
			<th>전일 대비 매출액 증감 비율</th>
			<th>관객수 증감분</th>
			<th>관객수 증감 비율</th>
			<th>랭킹에 신규진입여부</th>
			<th>박스오피스 순위</th>
			<th>개봉일</th>
			<th>매출액 증감분</th>
			<th>해당일자에 상영된 횟수</th>
			<th>누적관객수</th>
		</tr>
		<c:forEach var="movie" items="${rList}">
			<tr>
				<td>${movie.rnum}</td>
				<td>${movie.audiCnt}</td>
				<td>${movie.salesAcc}</td>
				<td>${movie.scrnCnt}</td>
				<td>${movie.rankInten}</td>
				<td>${movie.salesShare}</td>
				<td>${movie.movieNm}</td>
				<td>${movie.salesAmt}</td>
				<td>${movie.movieCd}</td>
				<td>${movie.salesChange}</td>
				<td>${movie.audiInten}</td>
				<td>${movie.audiChange}</td>
				<td>${movie.rankOldAndNew}</td>
				<td>${movie.rank}</td>
				<td>${movie.openDt}</td>
				<td>${movie.salesInten}</td>
				<td>${movie.showCnt}</td>
				<td>${movie.audiAcc}</td>
			</tr>
		</c:forEach>
	</table>









</body>
</html>