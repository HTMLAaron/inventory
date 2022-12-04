<!DOCTYPE html>
<html>
    <body> 
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <h1>&nbsp;&nbsp;Home</h1>
     
    <br/>    
    <table class="table">
    <tr>
    <td><a href="/inventory/categorylist" class="btn btn-info">Category list</td>
    <td> <a href="/inventory/category" class="btn btn-info" >Add category</a></td>
    </tr>
    <tr>
   <td> <a href="/inventory/list/productlist" class="btn btn-info">Product list</a></td>
   <td> <a href="/inventory/upload/product" class="btn btn-info">Add product</a></td>
   </tr>
   <tr>
   <td>  <a href="/inventory/list/inventorylist" class="btn btn-info">Inventory list</a></td>
   <td> <a href="/inventory/upload/inventory" class="btn btn-info">Add inventory</a></td>
   </tr>
   <p>${status}</p>
    </table>
    </body>
</html>

