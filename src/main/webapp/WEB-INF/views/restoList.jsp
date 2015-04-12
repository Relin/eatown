<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<style>
table.reference tr:nth-child(even) {
  background-color: #ffffff;
  border: 1px solid #000;
}
tbody {
  display: table-row-group;
  vertical-align: middle;
  border-color: inherit;
}
table.reference tr:nth-child(odd) {
  background-color: #f1f1f1;
}
tr {
  display: table-row;
  vertical-align: inherit;
  border-color: inherit;
}
</style>
<div style="margin: 10px;">
	<h4>Liste des restaurants</h4>
	<table style="width: 600px" class="reference">
		<tbody>
		<tr>
			<th>No.</th>
			<th>Nom</th>
			<th>Adresse</th>
		</tr>
		<c:forEach var="resto" items="${requestScope.resto}"
			varStatus="loopCounter">
			<tr>
				<td><c:out value="${loopCounter.count}" /></td>
				<td><c:out value="${resto.name}" /></td>
				<td><c:out value="${resto.address}" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>