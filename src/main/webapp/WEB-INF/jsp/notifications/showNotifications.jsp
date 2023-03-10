<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<petclinic:layout pageName="showNotifications">
		<h2><fmt:message key="notifications"/></h2>
		<table id="notificationsTable" class="table table-striped">
			<thead>
		        <tr>
		            <th style="width: 150px;"><fmt:message key="name"/></th>
		            <th style="width: 200px;"><fmt:message key="owner"/></th>
		            <th style="width: 120px"><fmt:message key="comment"/></th>
		            <th style="width: 120px"><fmt:message key="options"/></th>
		        </tr>
		    </thead>
		    <tbody>
	        <c:forEach items="${notifications}" var="notifications">
	            <tr>
	                <td>
	                   <c:out value="${notifications.pet.name}"/>
	                </td>
	               
	                <td>
	                    <c:out value="${notifications.owner.firstName}"/>
	                </td>
	                <td>
	                    <c:out value="${notifications.comment}"/>
	                </td>
	                <td>
						<a href="<spring:url value="/notifications/${notifications.id}/acceptAdoption" htmlEscape="true" />"><fmt:message key="accept"/></a>
						<a href="<spring:url value="/notifications/${notifications.id}/delete" htmlEscape="true" />"><fmt:message key="decline"/></a>
	                </td>
	            </tr>
	        </c:forEach>
	        </tbody>
	     </table>   
</petclinic:layout>
