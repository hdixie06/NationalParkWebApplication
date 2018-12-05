<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ include file="common/header.jspf"%>
<style>
a {
	font-size: 19px;
	color: black;
}

hr {
	width: 80%;
	border-style: dashed;
	border-width: 2px;
	border-color: black;
}

body {
	font-family: 'Gill Sans', 'Gill Sans MT', Calibri, 'Trebuchet MS',
		sans-serif;
	color: white;
}

.circleShape {
	margin-top: 35px;
	margin-right: 10px;
	margin-bottom: 10px;
}

.circleShape p {
	display: inline;
	font-size: 18px;
	padding: 5px;
	line-height: 1.6;
}

.center {
	text-align: center;
}

h2 {
	display: inline-block;
	margin-top: 10px;
	background-color: black;
	color: white;
}

.quote {
	font-size: 18px;
	text-align: center;
	margin-top: 0px;
	margin-left: auto;
	margin-right: auto;
}

.circleShape .parkImages {
	width: 33%;
	height: auto;
	min-width: 420px;
	float: left;
	margin-left: 2rem;
	margin-right: 2rem;
	margin-bottom: 2rem;
	border-radius: 50%;
}

#weatherForecast {
	display: inline-block;
	color: black;
}

.parkInfo {
	display: inline-block;
	background-color: black;
	font-size: 30px;
	padding-left: 5px;
	padding-right: 5px;
}

th, td {
	border: 2px solid black;
	text-align: center;
}

table {
	width: 70%;
	margin-left: 15%;
	margin-right: 15%;
	display: flex;
	margin-right: 15px;
	justify-content: center;
}

.black {
	color: black;
}

.parkTitle {
	font-size: 21px;
}

.foundedStyle {
	color: white;
	background-color: black;
	padding: 2px;
}

.trCategories {
	color: black;
	font-weight: bold;
}

#tempToggle {
	text-align: center;
	margin-bottom: 5px;
}

#forecastDisplay {
	display: flex;
	justify-content: center;
}

.weatherImgPrimary {
	height: 150px;
	width: 150px;
	margin-left: 10px;
	margin-right: 10px;
}

.weatherImg {
	height: 100px;
	width: 100px;
	margin-left: 10px;
	margin-right: 10px;
}

.temperatureDisplay {
	float: left;
	clear: left;
}
</style>

<section>
	<div class="center">
		<p class="parkInfo">
			<b>${park.parkName}</b> <span class="parkTitle">(${park.state})</span>
		</p>
	</div>
	<p class="quote">
		<i>"${park.quote}" - <b>${park.quoteSource}</b></i>
	</p>
	<hr>
	<div class="circleShape">
		<img src="img/parks/${park.parkCode.toLowerCase()}.jpg"
			class="parkImages" />
		<p>
			<span class="foundedStyle"><b>Founded in:
					${park.yearFounded}.</b></span>&nbsp;<b>${park.description}.</b> &nbsp;<b>This
				<span class="black">${park.climate.toLowerCase()}</span> park
				contains <span class="black">${park.animalSpecies}</span> different
				animal species and attracts about <span class="black">${park.formattedAnnualVisitors}</span>
				visitors a year.
			</b>
		</p>
	</div>
	<hr>
	<div class="center">
		<h2>Some things to know before you go...</h2>
	</div>
	<div class="center">
		<table>
			<tr class="trCategories">
				<td>Acreage:</td>
				<td>Elevation:</td>
				<td>Total Trail Length:</td>
				<td>Number of Campsites:</td>
				<td>Entry Fee (USD)</td>
			</tr>
			<tr>
				<td>${park.formattedAcreage}miles</td>
				<td>${park.formattedElevation}feet</td>
				<td>${park.formattedMilesOfTrail}miles</td>
				<td>${park.campsites}</td>
				<td>$${park.entryFee}</td>
			</tr>
		</table>
	</div>
	<br /> <br />
	<div id="tempToggle">
		<c:url value="/toggleTemperature" var="toggleUrl">
			<c:param name="parkCode" value="${park.parkCode}" />
		</c:url>
		<form method="POST" action="${toggleUrl}">
			<input type="submit" value="Toggle Fahrenheit/Celsius" />
		</form>
	</div>
	<div id="forecastDisplay">
		<c:forEach var="forecast" items="${weather}">

			<div>
				<img
					class="${forecast.dayValue == 1 ? 'weatherImgPrimary' : 'weatherImg' }"
					src="img/weather/${forecast.formattedImageName}.png" />
			</div>

			<div class="temperatureDisplay">
				<c:choose>
					<c:when test="${isFahrenheit == true}">
						<div>High: ${forecast.high}&#176F</div>
						<div>Low: ${forecast.low}&#176F</div>
					</c:when>
					<c:otherwise>
						<div>
							High:
							<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${(forecast.high - 32) * 5/9}" />
							&#176C
						</div>
						<div>
							Low:
							<fmt:formatNumber type="number" maxFractionDigits="2"
								value="${(forecast.low - 32) * 5/9}" />
							&#176C
						</div>
					</c:otherwise>
				</c:choose>
				<c:if test="${forecast.dayValue == 1}">
					<c:forEach items="${forecast.weatherRecommendation}" var="rec">
						<p>${rec}</p>
					</c:forEach>
				</c:if>
			</div>
		</c:forEach>
	</div>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
