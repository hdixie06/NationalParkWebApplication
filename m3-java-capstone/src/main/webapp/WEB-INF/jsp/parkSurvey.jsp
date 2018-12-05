<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="common/header.jspf"%>
<style>
section {
	background-color: rgb(104, 120, 10);
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS', sans-serif;
	color: black;
	font-size: 19px;

}
.white {
	color: white;
}
.center {
	text-align: center;
}
.voteHeader {
	display: inline-block; 
	font-size: 20px; 
	color: white; 
	background-color: black;
	padding: 5px; 
	margin-left: 70px;
	margin-bottom: 25px;
	margin-top: 20px;
}
.error {
	 display: inline-block; 
	 padding: 5px; 
	 color: red; 
	 margin-left: 100px; 
	 margin-bottom: 15px;
	 background-color: white;
}
.parkTable {
	margin-left: 70px;
}
.button {
	background-color: black; 
	border: none; 
	height: 30px; 
	width: 80px; 
	font-size: 16px;
}

</style>
	<section>
		<br/>
		<div class="voteHeader"><b>Please vote on your favorite national park!</b></div>
		<br/>
		
		<c:if test="${not empty emailError}">
			<div class="error">**Please include a valid email address**</div>
			<br/>
		</c:if>
		
		<c:url value="/parkSurvey" var="processSurvey"/>
		<form method="POST" action="${processSurvey}">
			<table class="parkTable">
			<tr>
			<td><label for="favePark">Favorite National Park: </label></td>
			<td><select name="parkCode">
				<c:forEach items="${parkList}" var="park">
					<option value="${park.parkCode}">${park.parkName}</option>
				</c:forEach>
			</select></td>
			</tr>
			
			<tr>
			<td><label for="userEmail">Your email: </label></td>
			<td><input id="userEmail" type="text" name="emailAddress" required/></td>
			</tr>
			
			<tr>
			<td><label for="stateResidence">State of residence: </label></td>
			<td><select name="state">
				<c:import url="/WEB-INF/jsp/common/stateList.jsp"/>
			</select></td>
			</tr>

			<tr>
			<td><label for="activityLevel">Activity Level: </label></td>
			<td class="white">
				<input id="activityLevel" type="radio" name="activityLevel" value="inactive" 
				checked="checked" required/>inactive
				<input id="activityLevel" type="radio" name="activityLevel" value="sedentary"/>sedentary
				<input id="activityLevel" type="radio" name="activityLevel" value="active"/>active
				<input id="activityLevel" type="radio" name="activityLevel" value="extremely active"/>extremely active
			</td>
			</tr>
			<tr>
			<td colspan="2" class="center"><input type="submit" class="white button"/></td>
			</tr>
			</table>
		</form>
	
	</section>
	
<c:import url="/WEB-INF/jsp/common/footer.jsp" />