<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@include file="../includes/header.jsp"%>

<div class="bigPictureWrapper">
	<div class="bigPicture">
	</div>
</div>
<style>
.uploadResult {
	width: 100%;
	background-color: gray;
}

.uploadResult ul {
	display: flex;
	flex-flow: row;
	justify-content: center;
	align-items: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
	align-content: center;
	text-align: center;
}

.uploadResult ul li img {
	width: 100%;
}

.uploadResult ul li span {
	color: white;
}

.bigPictureWrapper {
	position: absolute;
	display: none;
	justify-content: center;
	align-items: center;
	top: 0%;
	width: 100%;
	height: 100%;
	background-color: gray;
	z-index: 100;
	background: rgba(255, 255, 255, 0.5);
}
.bigPicture {
	position: relative;
	display: flex;
	justify-content: center;
	align-items: center;
}
.bigPicture img {
	width: 600px;
}
</style>


<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">일반게시판 글쓰기</h1>

	<div class="card shadow mb-4">
		<div class="card-header py-3">일반게시판 글쓰기</div>
		<div class="card-body">
			<form role="form" action="write.do" method="post">
				<div class="form-group">
					<label>제목</label> <input class="form-control" name="title">
				</div>
				<div class="form-group">
					<label>내용</label>
					<textarea rows="3" name="content" class="form-control"></textarea>
				</div>
				<div class="form-group">
					<label>작성자</label> <input class="form-control" name="writer">
				</div>
				<div class="form-group">
					<label>비밀번호</label> <input class="form-control" name="pw"
						type="password">
				</div>
				<button type="submit" class="btn btn-primary">등록</button>
			</form>
		</div>
	</div>
	
	<div class="card">
		<div class="card-header py-3">File Attach</div>
		<div class="card-body">
			<div class="form-group uploadDiv">
				<input type="file" name="uploadFile" multiple>
			</div>
			<div class="uploadResult">
				<ul></ul>
			</div>
		</div>
	</div>

</div>


<script>
function showImage(fileCallPath) {
	//alert(fileCallPath);
	$(".bigPictureWrapper").css("display", "flex").show();
	
	$(".bigPicture").html("<img src='/display?fileName=" +encodeURI(fileCallPath) + "'>")
		.animate({width:'100%', height:'100%'}, 1000);
}

$(function(e) {
	console.log("form tag");
	var formObj = $("form[role='form']");
	
	$("button[type='submit']").on("click", function(e){
		e.preventDefault();
		
		console.log("submit clicked");
	});
	
	
	var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
	var maxSize = 5242880; // 5MB
	
	function checkExtension(fileName, fileSize) {
		if (fileSize >= maxSize) {
			alert("파일사이즈 초과");
			return false;
		}
		
		if (regex.test(fileName)) {
			alert("해당 종류의 파일은 업로드 할 수 없습니다.");
			return false;
		}
		return true;
	}
	
	
	$("input[type='file']").change(function(e){
		var formData = new FormData();
		var inputFile = $("input[name='uploadFile']");
		var files = inputFile[0].files;
		for (var i=0 ; i<files.length; i++) {
			if(!checkExtension(files[i].name, files[i].size)) {
				return false;
			}
			formData.append("uploadFile", files[i]);
		}
		
		
		$.ajax({
			url: '/uploadAjaxAction',
			processData: false,
			contentType: false,
			data: formData,
			type: 'POST',
			dataType: 'json',
			success: function(result) {
				console.log(result);
				showUploadResult(result);
			}
		});
		
	});
	
	
	function showUploadResult(uploadResultArr) {
		console.log(uploadResultArr);
		console.log(uploadResultArr.length);
		if (!uploadResultArr || uploadResultArr.length == 0) return;
		
		var uploadUL = $(".uploadResult ul");
		
		var str = "";
		
		$(uploadResultArr).each(function(i, obj){
			if (obj.fileType) {
				var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
				var originPath = obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName;
				originPath = originPath.replace(new RegExp(/\\/g), "/");
				console.log(fileCallPath);
				console.log(originPath);
				str += "<li><div>";
				str += "<span>" + obj.fileName + "</span>";
				str += "<button type='button' data-file=\'"+fileCallPath+"\' data-type='file' class='btn btn-secondary btn-circle'>";
				str += "<i class='fas fa-times'></i></button><br>";
				str += "<a href='javascript:showImage(\""+originPath +"\")'>";
				str += "<img src='/display?fileName="+fileCallPath+"'>";
				str += "</a>";
				str += "</div></li>"
			}
		});
		
		console.log("str: ", str);
		uploadUL.append(str);
	}
	
	$(".bigPictureWrapper").on("click", function(e) {
		$(".bigPicture").animate({width:'0%', height:'0%'}, 1000);
		setTimeout(()=>{
			$(this).hide();
		}, 1000);
	});
	
	
	$(".uploadResult").on("click", "button", function(e) {
		console.log("delete file");
		var targetFile = $(this).data("file");
		var type = $(this).data("type");
		
		var targetLi = $(this).closest("li");
		
		$.ajax({
			url: '/deleteFile',
			data: {fileName: targetFile, type:type},
			dataType: 'text',
			type: 'POST',
			success: function(result) {
				alert(result);
				targetLi.remove();
			}
		});
	});
	
	
	
});
</script>

<%@include file="../includes/footer.jsp"%>
