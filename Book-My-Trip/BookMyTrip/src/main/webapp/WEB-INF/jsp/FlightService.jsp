<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <style>
    .card{
  margin:auto;
  border:solid 1px #dbdad7;
  width:60%;
  padding-left:10px!important;
  padding-bottom:10px!important;
  padding-right:10px!important;
  padding-top: 0px!important;

}

.card-title{
  margin:auto;
  padding:15px;
  background-color: #2f7fad;
  color: white;
  width:80%;
}

div.card-body{
  padding:0px;
}
.custom-select{
  width:100%;
}

.btn2{
  margin-left:10%;
}
input {
  outline: 0!important;
  border-width: 0 0 2px!important;
  border-color: #d1d1cf!important;
}
input:focus {
  border-color: #d1d1cf!important;
 -webkit-box-shadow: none!important;
  box-shadow: none!important;
}

select{

 outline: 0!important;
  border-width: 0 0 2px!important;
  border-color: #d1d1cf!important;
}

select:focus{
    border-color: #d1d1cf!important;
 -webkit-box-shadow: none!important;
  box-shadow: none!important;
}

.radiobtn{
  margin-left: 3.5%;
}

.icons{
  margin:auto!important;

}

.fa{
  border-radius: 25px;
  width: 10%;
  margin-left: 5%;
  border:solid 2px #dbdad7;
  margin-top:5%;
  text-align: center;
}

.fa-plane{
  color:#1cad9f;
}

.fa-taxi{
  color: #c2f700;
}

.fa-train{
  color:red;
}

@media only screen and (max-width: 600px) {
  .card{
    margin:auto;
    border:solid 1px #dbdad7;
    width:90%;
    padding-left:10px!important;
    padding-bottom:10px!important;
    padding-right:10px!important;
    padding-top: 0px!important;

  }

  .fa{
    border-radius: 25px;
    width: 15%;
    margin-left: 5%;
    border:solid 2px #dbdad7;
    margin-top:5%;
    text-align: center;
  }
}
  </style>
</head>
<body>

<!--Card-->
<div class="card shadow mb-5 bg-white rounded mt-3">

	<!--Card-Body-->
	<div class="card-body">

		<!--Card-Title-->
		<p class="card-title text-center shadow mb-5 rounded">Flight Booking Form</p>

 <div class="icons text-center">

<a href="flights"><i class="fa fa-plane fa-3x" aria-hidden="true"></i></a>



 </div>

    <hr>

		<p class="searchText"><strong>Search For Flights</strong></p>

        <form method="post">
		<!--Second Row-->
		<div class="row">

			<div class="col-sm-6">
				<select class="browser-default custom-select mb-4" id="select" name="from">
        <option value="" disabled="" selected="">From City/Airport</option>
                <option value="New Delhi">New Delhi</option>
                <option value="Mumbai">Mumbai</option>
                <option value="Bangalore">Bangalore</option>
                <option value="Kolkata">Kokata</option>
                <option value="Varanasi">Varanasi</option>
                <option value="JammuAndKashmir">Jammu and Kashmir</option>
                <option value="Chennai">Cheenai</option>
                <option value="Jaipur">Jaipur</option>
                <option value="Hyderabad">Hyderabad</option>
    </select>
			</div>

			<div class="col-sm-6">
				<select class="browser-default custom-select mb-4" id="select" name="to">
        <option value="" disabled="" selected="">To City/Airport</option>
                <option value="New Delhi">New Delhi</option>
                <option value="Mumbai">Mumbai</option>
                <option value="Bangalore">Bangalore</option>
                <option value="Kolkata">Kokata</option>
                <option value="Varanasi">Varanasi</option>
                <option value="JammuAndKashmir">Jammu and Kashmir</option>
                <option value="Chennai">Cheenai</option>
                <option value="Jaipur">Jaipur</option>
                <option value="Hyderabad">Hyderabad</option>
    </select>
			</div>

		</div>


		<!--Third Row-->
		<div class="row">

			<div class="col-sm-6">
				<input placeholder="&#xf073; Departing" type="text" id="date-picker-example" class="form-control datepicker mb-4" style="font-family:Arial, FontAwesome" >
			</div>

				<div class="col-sm-6">
					<input placeholder="&#xf073; Arriving" type="text" id="date-picker-example" class="form-control datepicker" style="font-family:Arial, FontAwesome" >
			</div>

				</div>


				<!--Fifth Row-->
				<div class="row">

					<div class="col-sm-4">
						<select class="browser-default custom-select mb-4" id="select">
        <option value="" disabled="" selected="">Kids(0-14)</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
					</div>

					<div class="col-sm-4">
						<select class="browser-default custom-select mb-4" id="select">
        <option value="" disabled="" selected="">Adults(15-64)</option>
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
    </select>
					</div>

					<div class="col-sm-4">
						<select class="browser-default custom-select mb-4" id="select" name="classType">
        <option value="" disabled="" selected="">Class</option>
        <option value="Business">Business</option>
        <option value="Economy">Economy</option>
    </select>
					</div>



				</div>

				<Button class="btn btn-primary float-right mt-5">Find Flights</Button>
				</form>
			</div>
		</div>
</body>
</html>