<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello World</title>
<style>
	.top {width: 100%; height: 30px; background-color: yellow;}
</style>
</head>
   <body>
   <div class="top">
   어드민
   </div>
  
    <section class="content">
    
      <%-- <tiles:insertAttribute name="header"/> --%> 
      <!--  /WEB-INF/views/common/layout/header.jsp -->
      
      <tiles:insertAttribute name="body"/> <!-- body -->
      
      
      <%-- <tiles:insertAttribute name="footer"/> --%> 
      <!-- /WEB-INF/views/common/layout/footer.jsp -->
      
    </section>
  </body>
</html>