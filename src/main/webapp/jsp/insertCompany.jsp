<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Company</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
        integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css"
        integrity="sha384-6pzBo3FDv/PJ8r2KRkGHifhEocL+1X2rVCTTkUfGk7/0pbek5mMa1upzvWbrUbOZ" crossorigin="anonymous">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="CSS/style.css">
</head>
<body>
<div class="container-fuild">
        <div class="header">
            <h1 style="float:left;">Stock Exchange <i class="fa fa-line-chart" style="color:white;"></i></h1>
            <h3 style="float:right; margin-right:100px"><a href="#" style="color:white;">Logout</a></h3>
        </div>
        <div class="nav">
            <ul class="nav nav-tabs nav-justified">
                <li><a data-toggle="tab" href="#">Import Data</a></li>
                <li><a data-toggle="tab" href="/addcompany">Manage Data</a></li>
                <li><a data-toggle="tab" href="/stockexchange">Manage Exchange</a></li>
                <li><a data-toggle="tab" href="/ipoplanned">Update IPO details</a></li>
            </ul>
        </div>
        <form:form class="form-horizontal" action="/addcompany" method="POST" modelAttribute="company1">
            <div class="Absolute-Center is-Responsive">
                <h3 style="margin-left: 100px;">Create New Company</h3>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="companyCode">Company Code</label>
                    <div class="col-sm-4">
                        <form:input type="text" class="form-control" id="companyCode" path="companyCode"/>
                        <div class="has-error">
                        <form:errors path="companyCode" class="text-danger"/>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="companyName">Company Name</label>
                    <div class="col-sm-4">
                        
                             <form:input type="text" class="form-control" id="companyName" path="companyName"/>
                             <div class="has-error">
                              <form:errors path="companyName" class="text-danger"/>
                        </div>
                    </div>
                    
                </div>
                 <div class="form-group">
                    <label class="control-label col-sm-2" for="turnOver">TurnOver</label>
                    <div class="col-sm-4">
                        <form:input type="text" class="form-control" id="turnOver" path="turnOver"/>
                        <div class="has-error">
                        <form:errors path="turnOver" class="text-danger"/>
                        </div>
                    </div>
                    
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="ceo">CEO Name</label>
                    <div class="col-sm-4">
                        <form:input type="text" class="form-control" id="ceo" path="ceo"/>
                        <div class="has-error">
                        <form:errors path="ceo" class="text-danger"/>
                        </div>
                    </div>
                    
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="sectorId">Sector Id</label>
                    <div class="col-sm-4">
                        <form:input type="text" class="form-control" id="sectorId" path="sectorId"/>
                        <div class="has-error">
                        <form:errors path="sectorId" class="text-danger"/>
                        </div>
                    </div>
                    
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="boardOfDirectors">Board Of Directors</label>
                    <div class="col-sm-4">
                        <form:input type="text" class="form-control" id="boardOfDirectors" path="boardOfDirectors"/>
                        <div class="has-error">
                        <form:errors path="boardOfDirectors" class="text-danger"/>
                        </div>
                    </div>
                    
                </div>
                
                <div class="form-group">
                    <label class="control-label col-sm-2" for="briefWriteup">Brief Description</label>
                    <div class="col-sm-4">
                        <form:input type="text" class="form-control" id="briefWriteup" path="briefWriteup"/>
                        <div class="has-error">
                        <form:errors path="briefWriteup" class="text-danger"/>
                        </div>
                    </div>
                    
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="stockCode">Stock Code</label>
                    <div class="col-sm-4">
                        <form:input type="text" class="form-control" id="stockCode" path="stockCode"/>
                        <div class="has-error">
                        <form:errors path="stockCode" class="text-danger"/>
                        </div>
                    </div>
                    
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>
                </div>
            </div>
        </form:form>
        <div class="footer">
            <h3>Copyrights &copy 2019</h3>
        </div>
    </div>
</body>
</html>