<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/css/bootstrap.css"/>
<style>
	.row > div{
		border: 1px solid #ccc;
		text-align:center;
	}
	.row > div > div{
		border-bottom: solid 1px #ccc; 
		width: 100%;
	}
	div{
		padding:none;
	}
	.menu ul li{	
		text-align:center;
		
		list-style:none;
	}
	#info{
		padding: 0 !important;
		display: inline-block;
	}

	.imgcontainer {
	    text-align: center;
	    margin: 24px 0 12px 0;
	    position: relative;
	}
	
	.profile_middle profile_line{
		padding:10 px;
	}

	img.avatar {
	    width: 40%;
	    border-radius: 50%;
	}
	button{
		backgorund-color: #6ACCBF;
	};
	#mainContents{
		height:100%;
	}
</style>
</head>
<body>
<div class="container">
	<div class="row">
		<div class="col-xs-3" id="info">
			<div>
				<form class="" action="resources/users/signup.do" method="post" id="signupForm">
				    <div class="imgcontainer" boder: 1px solid>
				      <img src="${pageContext.request.contextPath }/resources/images/insert.png" alt="Avatar" class="avatar">
					</div>
				</form>
			</div>

			<div>
				<p>"$[dto.id]"</p>
			</div>
			<div class="menu">
				<ul>
					<li>						
				        <a class="active" href="">
				          <div class="">내 아이템</div>
				          <div class="">0</div>
				        </a>				      
					</li>
					<li class="infoli">
			        	<a href="">
			         		<div class="">남긴글</div>
			         		<div class="">0</div>
			        	</a>
					</li>
				</ul>
			</div>
			<div class="profile_middle profile_line">
			    <div class="time_ago">
			      <img alt="가입일" height="23" width="23" src="${pageContext.request.contextPath }/resources/images/date_icon.png">
			      <!----><span>$[date]</span>
			    </div>
			    <div class="address">
			      <img alt="주요 판매장소" height="23" width="23" src="${pageContext.request.contextPath }/resources/images/details_icon.png">
			      <!----><span>판매 장소가 없습니다.</span>
			    </div>
			    <div class="domain">
			      <img alt="회원샵 도메인 코드" height="23" width="23" src="${pageContext.request.contextPath }/resources/images/home_icon.png">
			      <!----><!---->
			        <a href="">
			          <span>##</span>
			        </a>
			      
			    </div>
			    <div class="${pageContext.request.contextPath }/resources/css/seller_contacts_btn">판매자 연락처</div>
			    <!---->
			</div>
			<div>
				<p>"$[자기소개]"</p>
			</div>			
			<div>
				<button type="button" class="btn btn-success">회원정보 수정</button>
			</div>
		</div>
		<div class="col-xs-9" id="mainContents">
			<h3>main 컨텐츠</h3>
			<img src="${pageContext.request.contextPath }/resources/images/img_default_item.png" alt=""
					height="80" width="80"/>
			<p>지금바로 안쓰는 아이템을 팔아보세요!</p>
		</div>
	</div>
</div>
</body>
</html>