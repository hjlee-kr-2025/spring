<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<%@include file="../includes/header.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">일반게시판 리스트</h1>
                    
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                        		<div class="float-right">
                        			<a class="btn btn-primary" href="writeForm.do"
                        				>글쓰기</a>
                        		</div>
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>글번호</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>조회수</th>
                                            <th>댓글</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list }" var="vo">
                                        	<tr>
                                        		<td><c:out value="${vo.no }" /></td>
                                        		<td><c:out value="${vo.title }" /></td>
                                        		<td><c:out value="${vo.writer }" /></td>
                                        		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.writeDate }" /></td>
                                        		<td><c:out value="${vo.hit }" /></td>
                                        		<td><c:out value="${vo.comment }" /></td>
                                        	</tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

<%@include file="../includes/footer.jsp" %>