<!DOCTYPE html>
<html>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
    <body>
        <h1>&nbsp;&nbsp;Category List</h1>
       <c:choose>
            <c:when test="${result==null}">
                <font size="4">There are no Category.</font><br/>
            </c:when>
            <c:otherwise>
                <table class="table table-striped">
                    <tr>
                         <th>Category Name</th>
                         <th>Description</th>
                    </tr>
                    <c:forEach items="${result}" var="result">
                         <tr>
                             <td>${result.categoryName}</td>
                             <td>${result.description}</td>
                         </tr>
                        
                    </c:forEach>
                </table>
            </c:otherwise>
    </c:choose>  
            <br/><a href="/inventory/" class="btn btn-info">Home</a><br/><br/>
            <a href="/inventory/category" class="btn btn-info">Add category</a><br/><br/>
    </body>
</html>
