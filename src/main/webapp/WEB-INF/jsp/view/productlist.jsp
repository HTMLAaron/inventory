<!DOCTYPE html>
<html>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
    <body>
        <h1>&nbsp;&nbsp;Product List</h1>
        <c:choose>
            <c:when test="${result== null}">
                <font size="4">There are no product.</font><br/>
            </c:when>
            <c:otherwise>
                <table class="table table-striped">
                    <tr>
                         <th style="text-align:center">Product ID</th>
                         <th>Product Name</th>
                         <th>Code</th>
                         <th>Weight(g)</th>
                    </tr>
                    <c:forEach items="${result}" var="result">
                         <tr>
                             <td style="text-align:center">${result.id}</td>
                             <td>${result.productName}</td>
                             <td>${result.code}</td>
                             <td>${result.weight}</td>
                         </tr>
                        
                    </c:forEach>
                </table>
            </c:otherwise>
    </c:choose>  
    
     
    <a href="/inventory/upload/product" class="btn btn-info">Add product</a>&nbsp;&nbsp;
    <a href="/inventory/" class="btn btn-info">Home</a>&nbsp;&nbsp;   
    <a href="/inventory/list/inventorylist" class="btn btn-info">Refresh</a>
    </body>
</html>
