<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Customer-Login</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        body{background-color: white;
        }
    </style>
</head>
<body>
    <a href="landingPage"><button class="btn m-lg-3 btn-dark position-fixed">Back</button></a>
    <h1 class="row justify-content-center align-items-center" style="margin-top: 1.7%;">Login User</h1>

    <div class="container-fluid h-100 mt-5">
        <div class="row justify-content-center align-items-center h-100">
            <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
                <form method="post">
                    <div class="form-group mb-3 alert alert-dismissable text-center">
                      <span class="text-success h4">${message} </span>
                    </div>
                    <div class="form-group mb-3">
                        <input class="form-control form-control-lg" placeholder="User Id" type="text" id="uid" name="userId" value="">
                    </div>
                    <div class="form-group mb-3">
                        <input class="form-control form-control-lg" placeholder="Password" type="text" id="upass" name="password" value="">
                    </div>
                    <div class="form-group">
                    <button class="btn btn-primary btn-lg btn-block">Login</button>
                    </div>
                </form>
            </div>
        </div>
        <div>
        <a href="register" class="row justify-content-center align-items-center" style="margin-top: 1%;color:black;font-weight:bold;">New User</a>
        </div>
    </div>




</body>
</html>