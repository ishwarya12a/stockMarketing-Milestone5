<%@ page language="java" contentType="text/html; charset=UTF-8"
 import="java.util.*,com.example.stockspring.model.Company"    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Manage Company</title>
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
<%
List companyList=(List)request.getAttribute("companyList");
System.out.println(companyList);
%>

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
         <form class="form-horizontal" action="/updatecompany" modelAttribute="update">
            <div class="Absolute-Center is-Responsive">
                <h3 style="margin-left: 100px;">List of Companies</h3>
            </div>
            <table id="table" class="table table-bordered" cellpadding="10" align="center">
            <tr>
            <th>Company Code</th>
            <th>Company Name</th>
             <th>TurnOver</th>
              <th>Ceo</th>
              <th>boardOfDirectors</th>
              <th>briefWriteup</th>
              <th>stockCode</th>
              <th>Action</th>
            </tr>
  <%
 for(int i=0;i<companyList.size();i++){
Company company=(Company)companyList.get(i);
%>
      <tr>
      <td><%= company.getCompanyCode() %></td> 
      <td><%= company.getCompanyName() %></td>  
      <td><%= company.getTurnOver() %></td>    
      <td><%= company.getCeo() %></td>
      <td><%= company.getBoardOfDirectors() %></td> 
      <td><%= company.getBriefWriteup() %></td> 
      <td><%= company.getStockCode() %></td>
      <td>
      <div class="form-group">
      <div class="col-sm-4"><a href="updatecompany?id=<%=company.getCompanyCode() %>"  class="btn btn-primary">Edit</a></div>
       <div class="col-sm-4"><a href="delete?id=<%=company.getCompanyCode() %>"  class="btn btn-primary">Delete</a>
      </div>
      </div></td>  
      </tr>
      <% }%>       
            </table>
        </form>
        <div class="footer">
            <h3>Copyrights &copy 2019</h3>
        </div>
    </div>
</body>

</html>