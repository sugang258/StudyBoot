<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temp/boot.jsp"></c:import>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">
<link href="/css/list.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
</head>
<body>
	<h1 class="text-center">List Page</h1>
	
	<table class="table table-striped-columns">
      <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">title</th>
      <th scope="col">writer</th>
      <th scope="col">contents</th>
      <th scope="col">hit</th>
      <th scope="col">regDate</th>
      
    </tr>
  </thead>
	<c:forEach items="${ar}" var="ar">
  <tbody>
    <tr>
      <th scope="row">${ar.num}</th>
      <td><a href="./detail?num=${ar.num}">${ar.title}</a></td>
      <td>${ar.writer}</td>
      <td>${ar.contents}</td>
      <td>${ar.hit}</td>
      <td>${ar.regDate}</td>
    </tr>
    
  </tbody>
  </c:forEach>

  </table>
  <div>
  	<a href="./write" class="btn btn-primary">Write</a>
  </div>
  
  <div class="container" id="pager">
		<nav aria-label="Page navigation example" class="justify-content-center">
			<ul class="pagination">
				<c:if test="${pager.pre}">
					<li class="page-item"><a class="page-link" href="./List?page=${pager.startNum-1}">Previous</a></li>
				</c:if>
				<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
					<li class="page-item"><a class="page-link" href="./List?page=${i}">${i}</a></li>
				</c:forEach>
							
				<li class="page-item ${pager.next?'':'disabled'}">
				<a class="page-link" href="./List?page=${pager.lastNum+1}">Next</a></li>
			</ul>
		</nav>
 </div>
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-u1OknCvxWvY5kfmNBILK2hRnQC3Pr17a+RTT6rIHI7NnikvbZlHgTPOOmMi466C8" crossorigin="anonymous"></script>
<script  src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<script type="text/javascript">
let result = '${param.result}';
if(result != ""){
      if(result == "1"){
         Swal.fire({
              title: "?????? ??????",  // title, text , html  ??? ??? ??????
              icon: "success",    //????????? ?????? ?????????

              showCancelButton: false,
              confirmButtonColor: '#3085d6',
              confirmButtonText: '??????',
              cancelButtonText: '??????',
              reverseButtons: true   // ?????? ?????? ??????
          } )
         
         
      }else {
         
         Swal.fire({
              title: "?????? ??????",  // title, text , html  ??? ??? ??????
              icon: "error",    //????????? ?????? ?????????

              showCancelButton: false,
              confirmButtonColor: '#3085d6',
              confirmButtonText: '??????',
              cancelButtonText: '??????',
              reverseButtons: true   // ?????? ?????? ??????
          } )
         
      }
      
      
   }
</script>
</body>
</html>