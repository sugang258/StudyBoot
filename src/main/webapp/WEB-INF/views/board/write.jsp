<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<c:import url="../temp/summer.jsp"></c:import>
<script defer type="text/javascript" src="/js/write.js"></script>
</head>
<body>
	<section class="container-fluid col-lg-8 mt-5">
		<h1>Board Write Page</h1>
		<div>
			<form action="write" method="post" enctype="multipart/form-data">
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">Title</label>
			    <input type="text" class="form-control" id="title" name="title">
			  </div>
			  <div class="mb-3">
			    <label for="exampleInputPassword1" class="form-label">contents</label>
	            <textarea  class="form-control add_ele" id="contents" name="contents" placeholder="강의 설명"></textarea>
			  </div>

			  <div>
				<div class="mb-3" id="files">

				</div>
				<div class="mb-3">
					<button type="button" id="fileAdd">FileAdd</button>
				</div>

			  </div>
			  <!-- <div class="mb-3">
			    <label for="file" class="form-label">File</label>
	            <input type="file"  class="form-control add_ele" id="file" name="files"/>
			  </div>
			  <div class="mb-3">
			    <label for="file" class="form-label">File</label>
	            <input type="file"  class="form-control add_ele" id="file" name="files"/>
			  </div> -->
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</section>
<script type="text/javascript">
      $(document).ready(function(){
        $("#contents").summernote({
          height:500,
          minHeight: null,             // 최소 높이
				  maxHeight: null,             // 최대 높이
			  	focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			  	lang: "ko-KR",					// 한글 설정
			  	placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정
			  	callbacks: {	//여기 부분이 이미지를 첨부하는 부분
            onImageUpload : function(files) {
              uploadSummernoteImageFile(files[0],this);
            },
            onPaste: function (e) {
              var clipboardData = e.originalEvent.clipboardData;
              if (clipboardData && clipboardData.items && clipboardData.items.length) {
                var item = clipboardData.items[0];
                if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
                  e.preventDefault();
                }
              }
            }
				  }
        });
      })
</script>
</body>
</html>