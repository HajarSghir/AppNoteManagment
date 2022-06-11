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
    <form action="${pageContext.request.contextPath}/prof/excelpreparation" modelAttribute="module">
    <label for="module">Choisit Un Module:</label>
    <select name="module" id="module">
    <option value="">--Selectionner un module--</option>
    <c:if test="${!empty Modules}">
         <c:forEach items="${Modules}" var="module" varStatus="loop">
             <option value="${module.getIdModule()}">${module.getTitre()}</option> 
         </c:forEach> 
     </c:if>
    </select>
    <input type="submit" value="Generer"/> 
    </form>
   


<jsp:include page="../fragments/userfooter.jsp" />

</div>