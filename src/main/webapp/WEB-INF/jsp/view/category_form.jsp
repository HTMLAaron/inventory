<!DOCTYPE html>
<html>
    <body>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
        <!--<h1>${initParam["class"]}</h1>-->
        <h1>&nbsp;&nbsp;Add Category</h1>
       <!-- <form method="POST" action="multiply">
            Positive argument 1: <input type="text" name="arg1" /><br />
            Positive argument 2: <input type="text" name="arg2" /><br />
            <input type="submit" value="Submit" />
        </form>-->
       <form:form method="POST"  modelAttribute="CategoryForm">
            <form:label path="categoryName">Category Name: </form:label>
            <form:input type="text" path="categoryName" /><br/>
            <form:label path="description">Description: </form:label>
            <form:input type="text" path="description" /><br/>
            <input type="submit" value="Submit"/>
        </form:form>
            
        <br/><a href="/inventory/" class="btn btn-info">Home</a><br/><br/>
       
       
    </body>
</html>
