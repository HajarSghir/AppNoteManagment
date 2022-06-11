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
    <form action="${pageContext.request.contextPath}/prof/SessionFormForm" modelAttribute="session">
    <label for="session">Choisit La Session:</label>
    <select name="session" id="session">
    <option value="">--Selectionner une session--</option>
    <option value="Normale">Session Normale</option> 
    <option value="Rattrapage">Session Rattrapage</option> 
     </select>
    <input type="submit" value="Generer"/> 
    </form>
   


<jsp:include page="../fragments/userfooter.jsp" />

</div>