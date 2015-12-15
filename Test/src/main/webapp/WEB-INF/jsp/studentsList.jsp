<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<style type="text/css">
    .divTable
    {
        display:  table;
        width:auto;
        background-color:#eee;
        border:1px solid  #666666;
        border-spacing:5px;/*cellspacing:poor IE support for  this*/
       /* border-collapse:separate;*/
    }

    .divRow
    {
       display:table-row;
       width:auto;
    }

    .divCell
    {
        float:left;/*fix for  buggy browsers*/
        display:table-column;
        width:200px;
        background-color:#ccc;
    }
</style>
</head>
<body>
<h2>Students Information!</h2>
<form id="form1">
      <div class="divTable">
             <div class="headRow">
                <div  class="divCell">Student Name</div>
                <div  class="divCell">Student Age</div>
             </div>

             <c:forEach var="student" items="${studentsData}">
	            <div class="divRow">
	                <div class="divCell"><c:out value="${student.name}"/></div>
	                <div class="divCell"><c:out value="${student.age}"/></div>
	            </div>
            </c:forEach>           
      </div>
  </form>
</body>
</html>