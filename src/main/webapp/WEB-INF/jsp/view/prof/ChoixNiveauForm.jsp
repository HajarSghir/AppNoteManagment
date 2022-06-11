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
    <form action="${pageContext.request.contextPath}/prof/NiveauForm" modelAttribute="niveau">
    <label for="niveau">Choisit Un Niveau:</label>
    <select name="niveau" id="niveau">
    <option value="">--Selectionner un niveau--</option>
    <c:if test="${!empty Niveaux}">
         <c:forEach items="${Niveaux}" var="niveau" varStatus="loop">
             <option value="${niveau.getIdNiveau()}">${niveau.getTitre()}</option> 
         </c:forEach> 
     </c:if>
    </select>
    <input type="submit" value="Generer"/> 
    </form>
   


<jsp:include page="../fragments/userfooter.jsp" />

</div>