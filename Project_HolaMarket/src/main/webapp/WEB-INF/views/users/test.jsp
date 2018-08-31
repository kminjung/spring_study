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
.form-light .font-small {
font-size: 0.8rem; }

.form-light [type="radio"] + label,
.form-light [type="checkbox"] + label {
font-size: 0.8rem; }

.form-light [type="checkbox"] + label:before {
top: 2px;
width: 15px;
height: 15px; }

.form-light input[type="checkbox"] + label:before {
content: '';
position: absolute;
top: 0;
left: 0;
width: 17px;
height: 17px;
z-index: 0;
border-radius: 1px;
margin-top: 2px;
-webkit-transition: 0.2s;
transition: 0.2s; }

.form-light input[type="checkbox"]:checked + label:before {
top: -4px;
left: -3px;
width: 12px;
height: 22px;
border-style: solid;
border-width: 2px;
border-color: transparent #EB3573 #EB3573 transparent;
-webkit-transform: rotate(40deg);
-ms-transform: rotate(40deg);
transform: rotate(40deg);
-webkit-backface-visibility: hidden;
-webkit-transform-origin: 100% 100%;
-ms-transform-origin: 100% 100%;
transform-origin: 100% 100%; }

.form-light .footer {
border-bottom-left-radius: .3rem;
border-bottom-right-radius: .3rem; }
</style>
</head>
<body>
<!--Section: Live preview-->
<section class="form-light">

<!--Form without header-->
<div class="card">

    <div class="card-body mx-4">

        <!--Header-->
        <div class="text-center">
            <h3 class="pink-text mb-5"><strong>Sign up</strong></h3>
        </div>

        <!--Body-->
        <div class="md-form">
            <input type="text" id="Form-email2" class="form-control">
            <label for="Form-email2">Your email</label>
        </div>

        <div class="md-form pb-3">
            <input type="password" id="Form-pass2" class="form-control">
            <label for="Form-pass2">Your password</label>
            <div class="form-check my-4">
              <input class="form-check-input" type="checkbox" id="defaultCheck12">
              <label for="defaultCheck12" class="grey-text">Accept the<a href="#" class="blue-text"> Terms and Conditions</a></label>
            </div>
        </div>

        <!--Grid row-->
        <div class="row d-flex align-items-center mb-4">

            <!--Grid column-->
            <div class="col-md-3 col-md-6 text-center">
                <button type="button" class="btn btn-pink btn-block btn-rounded z-depth-1">Sign up</button>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-md-6">
                <p class="font-small grey-text d-flex justify-content-end">Have an account? <a href="#" class="blue-text ml-1"> Log in</a></p>
            </div>
            <!--Grid column-->

        </div>
        <!--Grid row-->
    </div>

    <!--Footer-->
    <div class="footer pt-3 mdb-color lighten-3">

        <div class="row d-flex justify-content-center">
            <p class="font-small white-text mb-2 pt-3">or Sign up with:</p>
        </div>

        <div class="row mt-2 mb-3 d-flex justify-content-center">
            <!--Facebook-->
            <a class="fa-lg p-2 m-2 fb-ic"><i class="fa fa-facebook white-text fa-lg"> </i></a>
            <!--Twitter-->
            <a class="fa-lg p-2 m-2 tw-ic"><i class="fa fa-twitter white-text fa-lg"> </i></a>
            <!--Google +-->
            <a class="fa-lg p-2 m-2 gplus-ic"><i class="fa fa-google-plus white-text fa-lg"> </i></a>
        </div>

    </div>

</div>
<!--/Form without header-->

</section>
<!--Section: Live preview-->
<script>
var subjects = [
    "Where's My Stuff?",
    "Cancel Items or Orders",
    "Returns & Refunds",
    "Shipping Rates & Information",
    "Change Your Payment Method",
    "Manage Your Account Information",
    "About Two-Step Verification",
    "Cancel Items or Orders",
    "Change Your Order Information",
    "Contact Third-Party Sellers",
    "More in Managing Your Orders"
];

$('#form-autocomplete-2').mdb_autocomplete({
    data: subjects
});
</script>
</body>
</html>