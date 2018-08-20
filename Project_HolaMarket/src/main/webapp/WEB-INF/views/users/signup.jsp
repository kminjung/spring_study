<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>signup.form</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* Full-width input fields */
input[type=text], input[type=password],fieldset {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

/* Set a style for all buttons */
button {
    background-color: #009cde;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

/* Extra styles for the cancel button */
.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
    position: relative;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}


/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    left: 0;
    top: 0;
    width: 100%;/* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
    padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
    background-color: #fefefe;
    margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
    border: 1px solid #888;
    width: 40%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
    position: absolute;
    right: 25px;
    top: 0;
    color: #000;
    font-size: 35px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: red;
    cursor: pointer;
}

/* Add Zoom Animation */
.animate {
    -webkit-animation: animatezoom 0.6s;
    animation: animatezoom 0.6s
}

@-webkit-keyframes animatezoom {
    from {-webkit-transform: scale(0)} 
    to {-webkit-transform: scale(1)}
}
    
@keyframes animatezoom {
    from {transform: scale(0)} 
    to {transform: scale(1)}
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
</head>
<body>

<h2>회원가입</h2>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">
Sign Up</button>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="users/signup.do" method="post" id="signupForm">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <h1 style="color:#">회원가입 </h1>
      <img src="${pageContext.request.contextPath }/resources/images/insert.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
        <!-- <form action="signup.do" method="post" id="signupForm"> -->
	    <label for="id"><b>아이디</b></label>
	    <input type="text" name="id" id="id" placeholder="Enter Username" required><!--required - 필수입력란이라는 뜻-->
        <span id="checkResult"></span>

	    <label for="pwd"><b>비밀번호</b></label>
	    <input type="password" name="pwd" id="pwd" placeholder="Enter Password" name="pwd" required>

	    <label for="pwd2"><b>비밀번호 확인</b></label>
	    <input type="password" name="pwd2" id="pwd2" placeholder="Confirm Password" required>

	    <label for="email"><b>이메일</b></label>
	    <input type="text" name="email" id="email" placeholder="Email" required>      

	    <label for="ph"><b>휴대전화</b></label>
	    <input type="text" name="ph" id="ph" placeholder="Phone Number" required> 

        <label for="addr"><b>주소</b></label>
        <input type="text" name="addr" id="addr" placeholder="Address" required> 
        
   		<button type="submit"><b style="font-size: 120%">회원가입</b></button>

    </div>

  </form>
</div>

<script src="${pageContext.request.contextPath }/resources/js/jquery-3.3.1.js"></script>    
<script>
// Get the modal
var modal = document.getElementById('id01');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
//폼의 유효성 여부
var formValid=false;

$("#signupForm").submit(function(){
    //만일 폼의 유효성 여부가 false 이면 
    if(formValid==false){
        return false;//폼 전송 막기
    }
});

//아이디 입력란에 입력했을때 실행할 함수 등록 
$("#id").on("input", function(){
    //입력한 아이디를 읽어와서
    var inputId=$(this).val();
    //ajax 요청을 이용해서 서버에 보낸다.
    $.ajax({
        url:"${pageContext.request.contextPath}/users/checkid.do",//요청url 이 페이지를 받는 
        method:"post",
        data:{"inputId":inputId},
        success:function(responseData){//컨트롤러에서 응답되는 문자열이 JQuery문자열로 (responseData)로 들어온다.
            //뭐가 응답되는지 콘솔에 출력해 보기 
            console.log(responseData);
            // responseData 는 object 이다.
            // {canUse:true} 또는 {canUse:false}
            if(responseData.canUse){//Objcet 이기 때문에 . 할 수 있다.
                formValid=true;
                $("#checkResult")
                .text("사용가능")
                .css("color","#00ff00");
            }else{
                formValid=false;
                $("#checkResult")
                .text("사용불가")
                .css("color","#ff0000");
            }
        }
    });
});

</script>
</body>
</html>