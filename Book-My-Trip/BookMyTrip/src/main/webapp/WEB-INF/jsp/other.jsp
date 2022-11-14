<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Buses-Available</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.css" rel="stylesheet"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/5.0.0/mdb.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <style>
        body{background-color: white;
        margin:0;
        }


        .sidebar {
          margin: 0;
          padding: 0;
          width: 200px;
          background-color: #f1f1f1;
          position: fixed;
          height: 100%;
          overflow: auto;
        }

        .sidebar a {
          display: block;
          color: black;
          padding: 16px;
          text-decoration: none;
        }

        .sidebar a.active {
          background-color: #04AA6D;
          color: white;
        }

        .sidebar a:hover:not(.active) {
          background-color: #555;
          color: white;
        }

        div.content {
          margin-left: 200px;
          padding: 1px 16px;
          height: 1000px;
        }

        @media screen and (max-width: 700px) {
          .sidebar {
            width: 100%;
            height: auto;
            position: relative;
          }
          .sidebar a {float: left;}
          div.content {margin-left: 0;}
        }

        @media screen and (max-width: 400px) {
          .sidebar a {
            text-align: center;
            float: none;
          }
        }

    </style>

</head>
<body>
   <a href="ServicePage.jsp"><button class="btn m-lg-3 btn-dark">Back</button></a>


	<div class="sidebar w-auto" style="position:absolute;">
		<h4 class="p-3">Hotels Available at ${city}</h4>
		<hr style="border:5px">
        <c:forEach items="${hotels}" var="b">
          <a class="text-center text-white bg-success" href="#">${b.hname}&ensp;&ensp;&ensp;${b.hroomPrice}<hr></a>
        </c:forEach>
    </div>

    <c:choose>
    <c:when test="${mode=='BUSES'}">
    <h1 class="row justify-content-center align-items-center" style="margin-top: 1%;">Available Buses</h1>
   <div class="container-fluid w-50 mt-3">
       <table class="table table-dark table-sm text-center">
           <thead>
               <tr>
   				<th>Bus Id</th>
   				<th>Bus Name</th>
   				<th>Source</th>
   				<th>Destination</th>
   				<th>Class</th>
   				<th>Price/Seat</th>
   				<th></th>
               </tr>
           </thead>
           <tbody>
               <tr>
   			<c:forEach items="${buses}" var="e">
   				<tr>
   					<td>${e.busid}</td>
   					<td>${e.bname}</td>
   					<td>${e.source}</td>
   					<td>${e.destination}</td>
                    <td>${e.bclass}</td>
                    <td>${e.price}</td>
                    <td><button class="btn btn-primary btn">Go</button></td>
   				</tr>
   			</c:forEach>
               </tr>
           </tbody>
       </table>
   </div>
   </c:when>

       <c:when test="${mode=='TRAINS'}">
       <h1 class="row justify-content-center align-items-center" style="margin-top: 1%;">Available Trains</h1>
      <div class="container-fluid w-50 mt-3">
          <table class="table table-dark table-sm text-center">
              <thead>
                  <tr>
      				<th>Train No</th>
      				<th>Train Name</th>
      				<th>Source</th>
      				<th>Destination</th>
      				<th>Class</th>
      				<th>Price/Seat</th>
      				<th></th>
                  </tr>
              </thead>
              <tbody>
                  <tr>
      			<c:forEach items="${trains}" var="e">
      				<tr>
      					<td>${e.tno}</td>
      					<td>${e.tname}</td>
      					<td>${e.source}</td>
      					<td>${e.destination}</td>
                       <td>${e.tclass}</td>
                       <td>${e.price}</td>
                       <td><button class="btn btn-primary btn">Go</button></td>
      				</tr>
      			</c:forEach>
                  </tr>
              </tbody>
          </table>
      </div>
      </c:when>

      <c:when test="${mode=='FLIGHTS'}">
             <h1 class="row justify-content-center align-items-center" style="margin-top: 1%;">Available Flights</h1>
            <div class="container-fluid w-50 mt-3">
                <table class="table table-dark table-sm text-center">
                    <thead>
                        <tr>
            				<th>Train No</th>
            				<th>Train Name</th>
            				<th>Source</th>
            				<th>Destination</th>
            				<th>Class</th>
            				<th>Price/Seat</th>
            				<th></th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
            			<c:forEach items="${trains}" var="e">
            				<tr>
            					<td>${e.tno}</td>
            					<td>${e.tname}</td>
            					<td>${e.source}</td>
            					<td>${e.destination}</td>
                             <td>${e.tclass}</td>
                             <td>${e.price}</td>
                             <td><button class="btn btn-primary btn">Go</button></td>
            				</tr>
            			</c:forEach>
                        </tr>
                    </tbody>
                </table>
            </div>
            </c:when>

            <c:when test="${mode=='TRAINS'}">
                   <h1 class="row justify-content-center align-items-center" style="margin-top: 1%;">Available Trains</h1>
                  <div class="container-fluid w-50 mt-3">
                      <table class="table table-dark table-sm text-center">
                          <thead>
                              <tr>
                  				<th>Train No</th>
                  				<th>Train Name</th>
                  				<th>Source</th>
                  				<th>Destination</th>
                  				<th>Class</th>
                  				<th>Price/Seat</th>
                  				<th></th>
                              </tr>
                          </thead>
                          <tbody>
                              <tr>
                  			<c:forEach items="${trains}" var="e">
                  				<tr>
                  					<td>${e.tno}</td>
                  					<td>${e.tname}</td>
                  					<td>${e.source}</td>
                  					<td>${e.destination}</td>
                                   <td>${e.tclass}</td>
                                   <td>${e.price}</td>
                                   <td><button class="btn btn-primary btn">Go</button></td>
                  				</tr>
                  			</c:forEach>
                              </tr>
                          </tbody>
                      </table>
                  </div>
                  </c:when>
   </c:choose>

</body>
</html>