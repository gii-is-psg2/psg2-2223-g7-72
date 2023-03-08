<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<petclinic:layout pageName="pets">
    <h2><fmt:message key="pets"/></h2>
    <table id="petsTable" class="table table-striped">
        <thead>
        <tr>
            <th style="width: 150px;"><fmt:message key="name"/></th>
            <th style="width: 200px;"><fmt:message key="type"/></th>
            <th style="width: 120px"><fmt:message key="options"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pets}" var="pet">
            <tr>
            	
                <td>
                   <c:out value="${pet.name}"/>
                </td>
               
                <td>
                    <c:out value="${pet.type}"/>
                </td>

                <td>
                    <a href="<spring:url value="/pets/${pet.id}/edit" htmlEscape="true" />"><fmt:message key="adopt"/></a>
                </td>
                
                
            </tr>
        </c:forEach>
        </tbody>
    </table>
</petclinic:layout>
