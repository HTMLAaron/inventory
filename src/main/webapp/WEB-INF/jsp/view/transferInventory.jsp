<!DOCTYPE html>
<html>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
    <body>
        <h1>&nbsp;&nbsp;Transfer inventory</h1>
        <c:if test="${empty inventoryDetail}">Not Record</c:if>
        <c:if test="${not empty inventoryDetail}">
        <table class="table table-striped">
             <tr>
                         <th>Inventory ID</th>
                         <th>Product ID</th>
                         <th>Location</th>
                         <th>Quantity</th>
                         
             </tr>
               <tr>
                   <td>${inventoryDetail.id}</td>
                   <td>${inventoryDetail.productid}(${product.productName}) </td>
                   <td>${inventoryDetail.location}</td>
                   <td>${inventoryDetail.quantity}</td>
                </tr>  
               
               
        </table> 
          <br/> <br/>
                       <form:form method="POST" modelAttribute="transferForm" >
                             
                             <form:input type="hidden" path="inventoryid" value="${inventoryDetail.id}"/><!--from inventory id-->
                             <form:label path="location">Location: </form:label>
                             <form:input type="text" path="location" required="required"/>
                             <br/> <br/> 
                             <form:label path="amount">Transfer Amount: </form:label>
                             <form:input type="text" path="amount" min="1" required="required"/> <br/>
                             <input type="submit" value="Submit"/>
                       </form:form>
                       
       
                             <br/>
                             <br/>
            <h3>Inventory Reference:</h3>
            <table class="table table-striped">  
                <tr>
                         <th>Inventory ID</th>
                         <th>Product ID</th>
                         <th>Location</th>
                         <th>Quantity</th>
               </tr>
            <c:forEach items="${result}" var="result">
                 <c:if test="${inventoryDetail.id != result.id}">
                   
                     
                         <tr>
                             <td>${result.id}</td>
                             <td>${result.productid}</td>
                             <td>${result.location}</td>
                             <td>${result.quantity}</td>
                            
                         </tr>
                       
                 </c:if>
             </c:forEach>    
              </table>        
             <br/>
         </c:if>     
        <a href="/inventory/list/inventorylist" class="btn btn-info">Inventory list</a>   &nbsp;&nbsp;
        <a href="/inventory/list/productlist" class="btn btn-info">Product list</a>   &nbsp;&nbsp;  
        <a href="/inventory/" class="btn btn-info">Home</a>
    </body>
</html>
