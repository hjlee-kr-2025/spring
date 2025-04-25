<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
    
<%@include file="../includes/header.jsp" %>

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 mb-2 text-gray-800">일반게시판 리스트</h1>
                    
                    <!--  https://startbootstrap.com/ -->
     								<!-- https://datatables.net/ -->               
                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                        		<div class="float-right">
                        			<a class="btn btn-primary" href="write.do"
                        				>글쓰기</a>
                        		</div>
                            <h6 class="m-0 font-weight-bold text-primary">DataTables Example</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th class="sorting sorting_desc" aria-label="글번호: activate to sort column ascending"
                                            aria-sort="descending">글번호</th>
                                            <th>제목</th>
                                            <th>작성자</th>
                                            <th>작성일</th>
                                            <th>조회수</th>
                                            <th>댓글</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach items="${list }" var="vo">
                                        	<tr class="dataRow">
                                        		<td class="no"><c:out value="${vo.no }" /></td>
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


		<!-- Modal-->
    <div class="modal fade" id="msgModal" tabindex="-1" role="dialog" aria-labelledby="msgModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title" id="msgModalLabel">게시물 알림</h4>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">처리가 완료되었습니다.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">close</button>
                </div>
            </div>
        </div>
    </div>


<script type="text/javascript">
$(function(){
	var perPageNum = 10;
	if (${!empty param.perPageNum}) {
		perPageNum = parseInt("${param.perPageNum}");
	}
	var page = 1;
	var startRow = 0;
	if (${!empty param.page}) {
		page = parseInt("${param.page}");
		startRow = (page-1) * perPageNum;
	}
	
	console.log("perPageNum : ", perPageNum);
	console.log("startRow : ", startRow);
	
	
	let table = $('#dataTable').dataTable( {
		"order": [[0,'desc']],
		"language": {
			"paginate": {
				"previous": "<i class='fas fa-arrow-left'></i>",
				"next": "<i class='fas fa-arrow-right'></i>"
			}
		},
		"lengthMenu": [[5, 10, 15, 20], [5, 10, 15, 20]],
		"pageLength": perPageNum,
		"displayStart": startRow
	});
	
	var result = '<c:out value="${result}" />';
	console.log(result);
	
	checkModal(result);
	
	function checkModal(result) {
		if (result == '') {
			return;
		}
		
		if (parseInt(result) > 0) {
			$("#msgModal .modal-body").html("게시글 " + parseInt(result) + "번이 등록되었습니다.");
		}
		
		$("#msgModal").modal("show");
	}
	
	
	// 동적으로 생성될때 동적이 아닌 태그에서 이벤트를 위임해야 합니다.
	$(document).on("click", ".dataRow", function(){
		console.log(".dataRow click event");
		let no = $(this).find(".no").text();
		console.log("클릭한 글번호 : ", no);
		
		location="view.do?no="+no+"&inc=1&page="+page+"&perPageNum="+perPageNum;
	});
	
	$(document).on("click", ".pagination li", function(){
		page = $(this).find("a").text();
		console.log("page: ", page);
	});
	
});
</script>

<%@include file="../includes/footer.jsp" %>