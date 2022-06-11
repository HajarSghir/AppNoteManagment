<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>


<jsp:include page="../fragments/userheader.jsp" />
<div class="container">

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">



			<jsp:include page="../fragments/profmenu.jsp" />

		</div>
	</nav>
    <form action="${pageContext.request.contextPath}/prof/FiliereForm" modelAttribute="filiere">
    <label for="filiere">Choisit une filiere:</label>
    <select name="filiere" id="filiere">
    <option value="">--Selectionner une filiere--</option>
    <c:if test="${!empty Filieres}">
         <c:forEach items="${Filieres}" var="filiere" varStatus="loop">
             <option value="${filiere.getIdFiliere()}">${filiere.getTitreFiliere()}</option> 
         </c:forEach> 
     </c:if>
     </select>
    <input type="submit" value="Generer"/> 
    </form>
   


<jsp:include page="../fragments/userfooter.jsp" />

</div>