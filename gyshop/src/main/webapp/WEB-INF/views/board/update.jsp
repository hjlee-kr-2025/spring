<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp"%>
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">일반게시판 글수정</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">일반게시판 글수정</div>
		<div class="card-body">
			<form action="update.do" method="post">
				<div class="form-group">
					<label>글번호</label> <input class="form-control" value="${vo.no }"
						readonly name="no">
				</div>
				<div class="form-group">
					<label>제목</label> <input class="form-control" value="${vo.title }"
						name="title">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea rows="3" class="form-control" name="content">${vo.content }</textarea>
				</div>
				<div class="form-group">
					<label>작성자</label> <input class="form-control" name="writer"
						value="${vo.writer }">
				</div>
				<div class="form-group">
					<label>비밀번호</label> <input class="form-control" name="pw"
						type="password">
				</div>
				<button class="btn btn-primary">수정</button>
			</form>
		</div>
	</div>

</div>

<%@include file="../includes/footer.jsp"%>
