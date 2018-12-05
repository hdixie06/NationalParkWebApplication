<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--  use the import function -->
<%@ include file="common/header.jspf"%>


<style>

table {
	font-size: 18px;
	display: flex; 
	border-spacing: 20px 0px; 
	margin-bottom: 20px;
}
.detailRow {
	float: left;
}
.tdPadding {
	padding-top: 20px;
}
hr {	
	width: 100%;
    border-style: solid;
    border-width: 3px;
    border-color: white;

}
.parkStuff {
	color: black;
	background: white;
	border-radius: 10%;
	font-size: 20px;
}
.buttonClass {
	text-decoration: none;
	font-style: bold;
	color: white;
	background-color: black;
	font-size: 21px;
	border-style: solid;
	height: 50px;
	weidth: 400px;
	border-radius: 10%;
}
</style>

<section>

<c:forEach var="parks" items="${parkList}">
 
 	<c:url var="detailUrl" value="/parkDetails?parkCode=${parks.parkCode}"/>
 	<c:url var="imgUrl" value="img/parks/${parks.parkCode.toLowerCase()}.jpg"/>
	
	<table>
		<tr class="detailRow">
		<td class="tdPadding"><a href="${detailUrl}"><img src="${imgUrl}"/></a></td>
		</tr>
		<tr>
		<td class="tdPadding"><button type="button" class="buttonClass"><b><a href="${detailUrl}">${parks.parkName}</a></b></button></td>
		</tr>
		<tr class="parkStuff">
		<td>${parks.description}</td>
		</tr>
	</table>
		
	<hr>


</c:forEach>
</section>

</body>
</html>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />