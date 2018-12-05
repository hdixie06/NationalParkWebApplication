<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="common/header.jspf"%>

<style>
a {
	text-decoration: none;
	color: black;
}
.parkVotes {
	display: inline-block;
	background-color: white;
	font-size: 18px;
}
section { 
	background-color: rgb(104, 120, 10);
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
	color: black;
}

h2 {

	display: inline;
	padding: 5px;
	font-weight: bold;
	font-size: 28px;
	color: white;
	background-color: black;
} 
.favParkImage {
	
	width: 80%;
	margin-left: 10%;
	margin-right: 10%;
	margin-bottom: 40px;
	border-radius: 45%;
	
}
.container {
	text-align: center;
}
.border {
	border:5px dotted black;
	margin-left: 30%;
	margin-right: 30%;
}
#parkList {
	text-align: center;
}

</style>

<section>
	<br/>
	<div id="parkList">
	<h2>Here's a list of the top voted parks!</h2>
	</div>
	<br/>
	
	<c:forEach items="${favoriteParks}" var="park">
		<c:url var="detailUrl" value="/parkDetails?parkCode=${park.parkCode}"/>
		<c:url var="imgUrl" value="img/parks/${park.parkCode.toLowerCase()}.jpg"/>
		
		
		<div class="border">
		<div class="container">
			<p class="parkVotes">
			<b><a href="${detailUrl}">${park.parkName}:</a></b> ${park.votes} 
				<c:if test="${park.votes ==1 }">
				vote
				</c:if>
				<c:if test="${park.votes > 1}">
				votes
				</c:if>
			</p>
		</div>
		<div>
			<a href="${detailUrl}"><img src="${imgUrl}" class="favParkImage"/></a>
		</div>
		</div>

		
		<br/>

	</c:forEach>

</section>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />
