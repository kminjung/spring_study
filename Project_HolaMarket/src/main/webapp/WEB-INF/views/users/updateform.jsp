<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
input[type=text], input[type=password],fieldset {
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: inline-block;
    
    box-sizing: border-box;
}
textarea{
	resize:none;
	width: 99%;
	
	
}
rbtn{
	background-color: #FF0000;
}

/* Set a style for all buttons */
button {
    background-color: #009cde;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 49.5%;
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
.introduce{ 
	width:100%;
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

<h2>회원정보 수정</h2>

<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">
회원정보 수정</button>

<div id="id01" class="modal">
  
  <form class="modal-content animate" action="users/signup.do" method="post" id="updateForm">
    <div class="imgcontainer">
      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
      <h1 style="color:#">회원정보 수정 </h1>
      <img src="${pageContext.request.contextPath }/resources/images/insert.png" alt="Avatar" class="avatar">
    </div>

    <div class="container">
    
	    <label for="email"><b>이메일</b></label>
	    <input type="text" name="email" id="email" value="${dto.email }" placeholder="Email" required>      

	    <label for="ph"><b>휴대전화</b></label>
	    <input type="text" name="ph" id="ph" value="${dto.ph }" placeholder="Phone Number" required> 

        <label for="addr"><b>주소</b></label>
        <input type="text" name="addr" id="addr" value="${dto.addr }" placeholder="Address" required> 
        
        <label for="introduce"><b>자기소개</b></label>
        <textarea rows="5" type="text" id="introduce" class="form-control md-textarea"></textarea> 
              

        
        <button type="reset"><b class="rbtn" style="font-size: 120%"; background-color: #FF0000>수정취소</b></button>
   		<button type="submit"><b style="font-size: 120%">수정완료</b></button>

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
</script>
</body>
</html>