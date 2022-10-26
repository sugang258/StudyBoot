<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<c:import url="../temp/boot.jsp"></c:import>
<script defer src="/js/memberAdd.js"></script>
<body>
	<form action="./add" method="post" id="joinForm">
					<div class="row">
						<label for="ipId" class="form-label"><b>아이디</b></label>
					</div>
					<div class="row">
						<div class="col-6">
							<input type="text" name="id" class="form-control border-success border-opacity-25" id="ipId" placeholder="아이디를 입력해주세요">
						</div>
					</div>
					<div class="my-4">
						<label for="ipPw" class="form-label"><b>비밀번호</b></label>
						<input type="text" name="pw" class="form-control border-success border-opacity-25" id="ipPw" placeholder="비밀번호를 입력해주세요">
					</div>
					
					<div class="mb-4">
						<label for="ipPwCheck" class="form-label"><b>이름</b></label>
						<input type="text" name="name" class="form-control border-success border-opacity-25" id="name" placeholder="이름을 입력해주세요">
					</div>
					
					<div class="mb-4">
						<label for="email" class="form-label"><b>이메일</b></label>
						<input type="text" name="email" class="form-control border-success border-opacity-25" id="email" placeholder="이메일을 입력해주세요">
					</div>
					
					<input type="button" id="joinButton" value="회원가입"/>
	</form>

	<div>
		<div>
			ALL	<input type="checkbox" id="all">
		</div>

		<div>
			동의1 <input type="checkbox" class="check" name="" id="">
			<div>
				약관1
			</div>
		</div>
		<div>
			동의2 <input type="checkbox" class="check" name="" id="">
			<div>
				약관2
			</div>
		</div>
		<div>
			동의3 <input type="checkbox" class="check" name="" id="">
			<div>
				약관3
			</div>
		</div>

	</div>

</body>
</html>