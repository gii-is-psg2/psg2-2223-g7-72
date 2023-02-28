<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>


<petclinic:layout pageName="vets">
    <h2><fmt:message key="vets"/></h2>

    <table id="vetsTable" class="table table-striped">
        <thead>
        <tr>

            <th><fmt:message key="vets"/></th>
            <th><fmt:message key="specialtiesVet"/></th>
            <th><fmt:message key="options"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${vets.vetList}" var="vet">
            <tr>
                <td>
                    <c:out value="${vet.firstName} ${vet.lastName}"/>
                </td>
                <td>
                    <c:forEach var="specialty" items="${vet.specialties}">
                        <c:out value="${specialty.name} "/>
                    </c:forEach>
                    <c:if test="${vet.nrOfSpecialties == 0}"><fmt:message key="none"/></c:if>
                </td>
                <td>
                    <sec:authorize access="hasAuthority('admin')">
                    <a href="<spring:url value="/vets/${vet.id}/edit" htmlEscape="true" />">Edit</a>
                    <a href="<spring:url value="/vets/${vet.id}/delete" htmlEscape="true" />">Delete</a>
                </sec:authorize>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <table class="table-buttons">
        <tr>
            <td>
                <a href="<spring:url value="/vets.xml" htmlEscape="true" />"><fmt:message key="viewasXML"/></a>
            </td>            
        </tr>
    </table>

    <sec:authorize access="hasAuthority('admin')">
		<a class="btn btn-default" href='<spring:url value="/vets/new" htmlEscape="true"/>'>Add vet</a>
	</sec:authorize>

</petclinic:layout>
