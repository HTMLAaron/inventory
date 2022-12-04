    <!DOCTYPE html>
<html>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
    <body>
        <h1>&nbsp;&nbsp;Inventory List</h1>
        
        <c:choose>
            <c:when test="${result== null}">
                <c:if test="${status==null}">
                <font size="4">There are no Inventory.</font><br/>
                </c:if>
                <c:if test="${status!=null}">&nbsp;&nbsp;${status}<br/><br/></c:if>
                
                
            </c:when>
            <c:otherwise>
                <table class="table table-striped">
                    <tr>
                         <th style="text-align:center">Inventory ID</th>
                         <th>Product ID</th>
                         <th>Location</th>
                         <th>Quantity</th> 
                         <th>Inventory level</th>
                         <th>Transfer target</th>
                        
                    </tr>
                    <c:forEach items="${result}" var="result">
                         <tr>
                             <td style="text-align:center">${result.id}</td>
                             <td>${result.productid}</td>
                             <td>${result.location}</td>
                             <td>${result.quantity}</td>
                             <td>
                                 
                                 <c:choose>
                                     <c:when test="${result.quantity>=0 and result.quantity<=124}">Minimum</c:when>
                                     <c:when test="${result.quantity>=125 and result.quantity<=249}">Danger</c:when>
                                     <c:when test="${result.quantity>=250 and result.quantity<=374}">Average</c:when>
                                     <c:when test="${result.quantity>=375 and result.quantity<=500}">Maximum</c:when>
                                     <c:otherwise></c:otherwise>
                                     
                                     
                                 </c:choose>
                                 
                                 
                                 
                             </td>
                             <td>
                                 <a href="<c:url value="/transfer/${result.id}"/>" class="btn btn-info">Transfer</a>
                             </td>
                         </tr>
                        
                    </c:forEach>
                </table>
            </c:otherwise>
    </c:choose>  
    
     
    <a href="/inventory/upload/inventory" class="btn btn-info">Add inventory</a> &nbsp;&nbsp; 
    <a href="/inventory/" class="btn btn-info">Home</a> &nbsp;&nbsp;
    <a href="/inventory/list/inventorylist" class="btn btn-info">Refresh</a><br/><br/>   
    </body>
</html>
