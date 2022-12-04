<!DOCTYPE html>
<html>
    <body>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <!--<h1>${initParam["class"]}</h1>-->
       <c:set var="title" value="${fn:split(requestScope['javax.servlet.forward.request_uri'], '/')}" />
       <h1>&nbsp;&nbsp;Add ${title[2]} by CSV</h1>
      
           <form:form method="POST" enctype="multipart/form-data" modelAttribute="uploadForm">
            <b>Add attachments:</b><br/><br/>
            
            <form:input type="file" path="attachments" accept="text/csv"/><br/> 
            
            <input type="submit" value="Upload"/><br/><br/>
           </form:form> 
            
    <br/><a href="/inventory/" class="btn btn-info">Home</a><br/><br/>
    
           
    </body>
</html>
