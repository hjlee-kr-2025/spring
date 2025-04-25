<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    

<%@include file="../includes/header.jsp" %>
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">일반게시판 글보기</h1>
                    
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			일반게시판 글보기
		</div>
		<div class="card-body">
				<div class="form-group">
					<label>글번호</label>
					<input class="form-control" value="${vo.no }" readonly>
				</div>
				<div class="form-group">
					<label>제목</label>
					<input class="form-control" value="${vo.title }" readonly>
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea rows="3" class="form-control" readonly>${vo.content }</textarea>
				</div>
				<div class="form-group">
					<label>작성자</label>
					<input class="form-control" readonly value="${vo.writer }">
				</div>
				<div class="form-group">
					<label>작성일</label>
					<input class="form-control" readonly
					 value="<fmt:formatDate pattern='yyyy-MM-dd' value='${vo.writeDate }'/>">
				</div>
				<div class="form-group">
					<label>조회수</label>
					<input class="form-control" readonly value="${vo.hit }">
				</div>
				<a href="update.do?no=${vo.no }" class="btn btn-primary">수정</a>
				<button type="button" data-toggle="modal" data-target="#msgModal"
					class="btn btn-danger">삭제</button>
				<a href="list.do?page=${param.page }&perPageNum=${param.perPageNum}" class="btn btn-secondary">리스트</a>
		</div>
	</div>
                    
</div>

	<!-- Modal-->
    <div class="modal fade" id="msgModal" tabindex="-1" role="dialog" aria-labelledby="msgModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="msgModalLabel">삭제확인</h4>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <form action="delete.do" method="post">
                	<input type="hidden" name="no" value="${vo.no }">
	                <div class="modal-body"><p>삭제를 위한 비밀번호를 입력하세요?</p>
	                	<input type="password" name="pw" class="form-control">
	                </div>
	                <div class="modal-footer">
	                		<button class="btn btn-danger">삭제</button>
	                    <button class="btn btn-secondary" type="button" data-dismiss="modal">close</button>
	                </div>
                </form>
            </div>
        </div>
    </div>


<%@include file="../includes/footer.jsp" %>
